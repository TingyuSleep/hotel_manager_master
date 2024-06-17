package com.gk.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 会员信息
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vip {
    private int id;
    private String name;
    private String sex;
    private long card;
    private long phone;
    private String vtype;
    private String startTime;
    private String endTime;
}
