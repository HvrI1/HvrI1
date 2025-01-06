package com.hvri1.service.impl;

import com.hvri1.mapper.UserMapper;
import com.hvri1.pojo.User;
import com.hvri1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();;
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public User addUser(User user) {
        //对密码进行md5加密后存入数据库

        return  ;
    }
}
