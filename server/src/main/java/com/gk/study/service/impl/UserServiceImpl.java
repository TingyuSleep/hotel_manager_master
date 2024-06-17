package com.gk.study.service.impl;


import com.gk.study.entity.User;
import com.gk.study.mapper.UserMapper;
import com.gk.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> getUserList(String keyword) {
        List<User> list = null;
        try {
            list = userMapper.list(keyword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User getAdminUser(User user) {

        User list = userMapper.getById(user);
        return list;
    }


    @Override
    public void createUser(User user) {
        userMapper.createUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userMapper.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }


    @Override
    public User getUserByUserName(String username) {
        User user = userMapper.getUserByUserName(username);
        return user;
    }

}
