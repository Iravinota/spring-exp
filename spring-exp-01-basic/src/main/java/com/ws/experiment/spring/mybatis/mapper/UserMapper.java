package com.ws.experiment.spring.mybatis.mapper;

import com.ws.experiment.spring.basic.User;

import java.util.List;

/**
 * UserMapper
 *
 * @author Eric at 2019-12-27_14:43
 */
public interface UserMapper {

    List<User> selectAll();

}
