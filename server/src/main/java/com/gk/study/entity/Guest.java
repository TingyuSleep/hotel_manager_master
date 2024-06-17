package com.gk.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guest {
    public String id;
    public String name;
    public String sex;
    public String phone;
    public String enterTime;
    public String hType;
    public String num;
}
