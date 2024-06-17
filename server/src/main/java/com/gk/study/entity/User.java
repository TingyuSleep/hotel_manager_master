package com.gk.study.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    public static final int NormalUser = 1;
    public static final int DemoUser = 2;
    public static final int AdminUser = 3;

    public String id;
    public String username;
    public String password;
    public String rePassword;
    public String nickname;
    public String mobile;
    public String email;
    public String description;
    public String role;
    public String status;
    public String score;
    public String avatar;
    public MultipartFile avatarFile;
    public String token;
    public String createTime;
    public String pushEmail;
    public String pushSwitch;

}
