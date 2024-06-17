package com.gk.study.controller;

import com.gk.study.common.APIResponse;
import com.gk.study.common.ResponeCode;
import com.gk.study.entity.Vip;
import com.gk.study.service.VipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */
@RestController
@RequestMapping("/vip")
@Slf4j
@CrossOrigin(origins = {"*"})
public class VipController {

    @Autowired
    private VipService vipService;

    /**
     * 查询vip信息
     * @param keyword
     * @return
     */
    @GetMapping(value = "/list")
    public APIResponse list(String keyword){
        log.info("开始查询vip信息,参数为{}",keyword);
        List<Vip> list =  vipService.getList(keyword);
        return new APIResponse(ResponeCode.SUCCESS, "查询成功", list);
    }

    /**
     * 新增操作
     * @param
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/create")
    @Transactional
    public APIResponse create(Vip vip) throws IOException {
        vipService.add(vip);
        return new APIResponse(ResponeCode.SUCCESS, "办理成功");
    }

    /**
     * 更新操作
     * @param
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/update")
    public APIResponse update(Vip vip) throws IOException {
        vipService.update(vip);
        System.out.println(vip);
        return new APIResponse(ResponeCode.SUCCESS, "更新成功");
    }
}
