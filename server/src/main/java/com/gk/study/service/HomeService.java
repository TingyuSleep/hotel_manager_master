package com.gk.study.service;

import com.gk.study.entity.Home;

import java.util.List;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */
public interface HomeService {
    List<Home> getList(String keyword);
}
