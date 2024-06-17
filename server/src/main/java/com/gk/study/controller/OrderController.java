package com.gk.study.controller;

import com.gk.study.common.APIResponse;
import com.gk.study.common.ResponeCode;
import com.gk.study.entity.Guest;
import com.gk.study.entity.Order;
import com.gk.study.service.GuestService;
import com.gk.study.service.OrderService;
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
@RequestMapping("/order")
@CrossOrigin(origins = {"*"})
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 查询订单信息
     *
     * @param
     * @return
     */
    @GetMapping(value = "/list")
    public APIResponse list() {
        log.info("开始查订单信息");
        List<Order> list = orderService.getOrderList();
        return new APIResponse(ResponeCode.SUCCESS, "查询成功", list);
    }



}
