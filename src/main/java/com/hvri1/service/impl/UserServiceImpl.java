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
        List<User> users = userMapper.selectAllUser();
        return users;
    }
}
