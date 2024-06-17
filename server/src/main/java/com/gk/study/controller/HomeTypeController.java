package com.gk.study.controller;



import com.gk.study.common.APIResponse;
import com.gk.study.common.ResponeCode;
import com.gk.study.entity.Tag;
import com.gk.study.service.HomeTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 房型统计相关接口
 * @version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/tag")
@CrossOrigin(origins = {"*"})
public class HomeTypeController {

    @Autowired
    private HomeTypeService homeTypeService;

    /**
     * 统计房型数量
     * @param
     * @return
     */
    @GetMapping(value = "/list")
    public APIResponse list() {
        log.info("开始统计房型数量");
        List<Tag> list = homeTypeService.getList();
        return new APIResponse(ResponeCode.SUCCESS, "查询成功", list);
    }
}
