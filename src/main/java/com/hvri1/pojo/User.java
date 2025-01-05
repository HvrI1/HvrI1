package com.hvri1.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //用户id
    private Integer userId;

    //用户账号
    private String userUsername;

    //用户密码
    private String userPassword;

    //用户姓名
    private String userName;

    //用户年龄
    private String userAge;

    //用户性别(0:女,1:男,2:保密)
    private Integer userSex;

    //用户邮箱
    private String userEmail;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime userUpdatetime;

    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime userCreatetime;
}
