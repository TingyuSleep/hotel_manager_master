package com.gk.study.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    public Long id;

    public String status;

    public String orderTime;

    public String payTime;

    public String thingId;

    public String userId;

    public String count;

    public String orderNumber; // 订单编号

    public String receiverAddress;

    public String receiverName;

    public String receiverPhone;

    public String remark;

    public String username; // 用户名

    public String title; // 商品名称

    public String cover; // 商品封面
    public String price; // 商品价格

}
