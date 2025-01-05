package com.hvri1.service;

import com.hvri1.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> selectAllUser();
}
