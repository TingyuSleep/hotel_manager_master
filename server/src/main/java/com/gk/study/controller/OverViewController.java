package com.gk.study.controller;

import com.gk.study.common.APIResponse;
import com.gk.study.common.ResponeCode;
import com.gk.study.entity.OverView;
import com.gk.study.entity.Vip;
import com.gk.study.service.OverViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/overview")
@CrossOrigin(origins = {"*"})
public class OverViewController {

    @Autowired
    private OverViewService overViewService;

    @GetMapping("/count")
    public APIResponse list(){
        log.info("开始查询销售额");
        OverView list =  overViewService.getList();
        return new APIResponse(ResponeCode.SUCCESS, "查询成功", list);
    }

}
