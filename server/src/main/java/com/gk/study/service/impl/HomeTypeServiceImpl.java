package com.gk.study.service.impl;

import com.gk.study.entity.Tag;
import com.gk.study.mapper.HomeTypeMapper;
import com.gk.study.service.HomeService;
import com.gk.study.service.HomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */
@Service
public class HomeTypeServiceImpl implements HomeTypeService {

    @Autowired
    private HomeTypeMapper homeTypeMapper;

    public List<Tag> getList(){
        List<Tag> list = homeTypeMapper.list();
        return list;
    }
}
