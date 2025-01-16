package com.hvri1.service.impl;

import com.hvri1.mapper.UserMapper;
import com.hvri1.pojo.User;
import com.hvri1.service.UserService;
import com.hvri1.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public void registerUser(User user) {
        String md5String = Md5Util.getMD5String(user.getUserPassword());
        user.setUserPassword(md5String);
        userMapper.registerUser(user);

    }

    @Override
    public String findUserPasswordByUsername(String username) {
        String db_encrypt_password = userMapper.findUserPasswordByUsername(username);
        return db_encrypt_password;
    }

//    @Override
//    public Integer updateUserInfoById(User user) {
//        //前端传进来的user没有id，这里需要使用local中的id信息
//        Integer id = 0;
//        //
//        userMapper.updateUserInfoById(id,user);
//        return null;
//    }


}
