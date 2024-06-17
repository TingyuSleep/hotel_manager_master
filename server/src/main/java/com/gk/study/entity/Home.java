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
public class Home {
    public Long id;

    public String title;

    public String cover;

    public String description;

    public String price;

    public String windows;

    public String sheshi;

    public String status;


}
