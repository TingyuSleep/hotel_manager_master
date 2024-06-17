package com.gk.study.mapper;

import com.gk.study.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */

@Mapper
public interface HomeTypeMapper {
    @Select("select b.id,b.title as hType, count(*) as num from b_classification b ,b_home c WHERE b.id = c.description GROUP BY b.id")
    List<Tag> list();
}
