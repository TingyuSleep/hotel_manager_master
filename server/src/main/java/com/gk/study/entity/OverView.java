package com.gk.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OverView {

    private String spzs;  //房间总数
    private String qrxz; //销售数量
    private String wfdd;
    private String wfddrs;
    private String yfdd;
    private String yfddrs;
    private String alldd;
    private String allmoney;
}
