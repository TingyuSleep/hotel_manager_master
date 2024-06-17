package com.gk.study.mapper;

import com.gk.study.entity.OverView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */

@Mapper
public interface OverViewMapper {

    //查询房间总数
    @Select("select count(*) as spzs from b_home ")
    OverView list1();
    @Select("select count(*) as qrxz from b_home where status = 1")
    OverView list2();
    @Select("select count(*) as wfdd,count(*) as wfddrs from b_order where status = 1")
    OverView list3();

    @Select("select count(*) as yfdd ,count(*) as yfddrs from b_order where status = 2")
    OverView list4();

    @Select("select count(*) as alldd ,sum(price) as allmoney from b_order")
    OverView list5();
}
