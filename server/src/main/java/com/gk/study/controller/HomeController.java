package com.gk.study.controller;

import com.gk.study.common.APIResponse;
import com.gk.study.common.ResponeCode;
import com.gk.study.entity.Guest;
import com.gk.study.entity.Home;
import com.gk.study.service.HomeService;
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
@RestController
@RequestMapping("/thing")
@Slf4j
@CrossOrigin(origins = {"*"})
public class HomeController {

    @Autowired
    private HomeService homeService;

    /**
     * 查询房间信息
     *
     * @param keyword
     * @return
     */
    @GetMapping(value = "/list")
    public APIResponse list(String keyword) {
        log.info("开始查询住户信息,参数为{}", keyword);
        List<Home> list = homeService.getList(keyword);
        return new APIResponse(ResponeCode.SUCCESS, "查询成功", list);
    }
}
