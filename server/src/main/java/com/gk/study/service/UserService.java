package com.gk.study.service;


import com.gk.study.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserList(String keyword);
    User getAdminUser(User user);
    void createUser(User user);
    void deleteUser(String id);

    void updateUser(User user);

    User getUserByUserName(String username);

}
