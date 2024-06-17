package com.gk.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 房型统计表
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    public Long id;

    public String hType;

    public Long num;
}
