package com.gk.study.mapper;

import com.gk.study.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper{


    List<User> list(String keyword);

    @Select("select * from b_user where username = #{username} and password = #{password}")
    User getById(User user);
    void updateUser(User user);


    //新增时需查询用户名是否已存在
    @Select("select * from b_user where username = #{username}")
    User getUserByUserName(String username);


    void createUser(User user);

    @Delete("delete from b_user where id = #{id}")
    void deleteById(String id);
}
