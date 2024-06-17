package com.gk.study.service.impl;


import com.gk.study.entity.Guest;
import com.gk.study.entity.User;
import com.gk.study.mapper.GuestMapper;
import com.gk.study.mapper.UserMapper;
import com.gk.study.service.GuestService;
import com.gk.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestMapper guestMapper;

    /**
     * 查询住户信息
     * @param keyword
     * @return
     */
    @Override
    public List<Guest> getGuestList(String keyword) {
        List<Guest> list = null;
        try {
            list = guestMapper.list(keyword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 新增
     * @param guest
     */
    @Override
    public void createGuest(Guest guest) {
        guestMapper.createGuest(guest);
    }

    /**
     * 修改
     * @param guest
     */
    public void updateGuest(Guest guest){
        guestMapper.updateGuest(guest);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteUser(String id) {
        guestMapper.deleteById(id);
    }


}
