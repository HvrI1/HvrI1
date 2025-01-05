package com.hvri1.mapper;

import com.hvri1.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    //查询所有用户信息
    @Select("select * from user")
    List<User> selectAllUser();
}
