package com.gk.study.mapper;

import com.gk.study.entity.Vip;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */
@Mapper
public interface VipMapper {
    List<Vip> list(String keyword);

    void add(Vip vip);

    void update(Vip vip);
}
