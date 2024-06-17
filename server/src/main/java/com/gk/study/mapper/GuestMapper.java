package com.gk.study.mapper;

import com.gk.study.entity.Guest;
import com.gk.study.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface GuestMapper {

    //查询操作
    List<Guest> list(String keyword);

    //新增操作
    void createGuest(Guest guest);
    //更新操作
    void updateGuest(Guest guest);
    //删除操作
    @Delete("delete from b_guest where id = #{id}")
    void deleteById(String id);
}
