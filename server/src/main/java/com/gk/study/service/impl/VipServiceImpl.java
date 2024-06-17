package com.gk.study.service.impl;

import com.gk.study.entity.Vip;
import com.gk.study.mapper.VipMapper;
import com.gk.study.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */

@Service
public class VipServiceImpl implements VipService {

    @Autowired
    private VipMapper vipMapper;

   public List<Vip> getList(String keyword){
       List<Vip> list = vipMapper.list(keyword);
       return list;
   }

    @Override
    public void update(Vip vip) {
        vipMapper.update(vip);
    }

    @Override
    public void add(Vip vip) {
        vipMapper.add(vip);
    }
}
