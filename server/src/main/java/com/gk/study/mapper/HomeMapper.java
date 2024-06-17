package com.gk.study.mapper;

import com.gk.study.entity.Home;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */

@Mapper
public interface HomeMapper {
    List<Home> list(String keyword);
}
