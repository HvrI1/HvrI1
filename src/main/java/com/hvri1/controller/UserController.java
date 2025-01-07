package com.hvri1.controller;

import com.hvri1.pojo.Result;
import com.hvri1.pojo.User;
import com.hvri1.service.UserService;
import com.hvri1.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    * 查询 get
    * 插入 post
    * 更新 put
    * 删除 delete
    * */


    //查询所有用户信息
    @GetMapping("/selectAllUser")
    public Result< List<User>> selectAllUser(){
        List<User> users = userService.selectAllUser();
        return Result.success(users);
    }

    //登录
    @PostMapping("/login")
    public Result<String> login(String username,String password){

        if(username==null || password==null) return Result.error("用户名或密码不能为空");
        User user = userService.findUserByUsername(username);
        if(user==null) return Result.error("用户不存在");
        if(!user.getUserPassword().equals(password)) return Result.error("用户名或密码错误");
        else {
            //利用jwt生成令牌
            HashMap<String, Object>  map = new HashMap<>();
            map.put("username",username);
            map.put("password",password);
            String token = JwtUtil.genToken(map);
            return Result.success(token);
        }
    }


    //注册
    @PostMapping("/register")
    public Result<User> register(@RequestBody User user){
        if(user.getUserName()==null||user.getUserPassword()==null) return Result.error("用户名或密码不能为空");
        User db_user = userService.findUserByUsername(user.getUserName());
        if(db_user!=null) return Result.error("用户已存在");
         userService.registerUser(user);
    }

}
