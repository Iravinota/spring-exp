package com.ws.experiment.spring.mybatis.dao;

import com.ws.experiment.spring.basic.User;
import com.ws.experiment.spring.mybatis.mapper.UserMapper;

import java.util.List;

/**
 * UserDao
 *
 * @author Eric at 2019-12-27_14:58
 */
public class UserDao {
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }
}
