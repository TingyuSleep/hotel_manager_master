package com.gk.study.mapper;

import com.gk.study.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from b_order")
    List<Order> getList();
}
