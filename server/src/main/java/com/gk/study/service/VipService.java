package com.gk.study.service;

import com.gk.study.entity.Vip;

import java.util.List;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */
public interface VipService {
    List<Vip> getList(String keyword);

    void update(Vip vip);

    void add(Vip vip);
}
