package com.hvri1.mapper;

import com.hvri1.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    //查询所有用户信息
    @Select("select * from user")
    List<User> selectAllUser();

    @Select("select * from user where user_username=#{username}")
    User findUserByUsername(String username);
    @Insert("insert into user (user_id,user_username,user_password,user_name,user_age,user_sex,user_email,user_updatetime,user_createtime)" +
            "values (#{userId},#{userUsername},#{userPassword},#{userName},#{userAge},#{userSex},#{userEmail},#{userUpdatetime},#{userCreatetime})")
    void registerUser(User user);
    @Select("select user_password from user where user_username=#{username}")
    String findUserPasswordByUsername(String username);

//    @Update("UPDATE user " +
//            "SET user_name = #{userName}, user_age = #{userAge},user_sex = #{userSex},user_name = #{userName},user_name = #{userName}," +
//            "WHERE condition;")
//    Integer updateUserInfoById(Integer id, User user);
}
