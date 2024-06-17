package com.gk.study.service.impl;

import com.gk.study.entity.Guest;
import com.gk.study.entity.Order;
import com.gk.study.mapper.GuestMapper;
import com.gk.study.service.OrderService;
import com.gk.study.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrderList() {
        List<Order> list = null;
        try {
            list = orderMapper.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
