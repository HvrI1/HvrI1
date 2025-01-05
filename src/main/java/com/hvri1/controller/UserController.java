package com.hvri1.controller;

import com.hvri1.pojo.Result;
import com.hvri1.pojo.User;
import com.hvri1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    * 查询 get
    * 修改 post
    * 更新 put
    * 删除 delete
    * */


    //查询所有用户信息
    @GetMapping("/selectAllUser")
    @ResponseBody
    public Result< List<User>> selectAllUser(){
        List<User> users = userService.selectAllUser();
        return Result.success(users);
    }



}
