package com.gk.study.service.impl;

import com.gk.study.entity.Home;
import com.gk.study.mapper.HomeMapper;
import com.gk.study.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper homeMapper;

    public List<Home> getList(String keyword){
        List<Home> list = homeMapper.list(keyword);
        return list;
    }
}
