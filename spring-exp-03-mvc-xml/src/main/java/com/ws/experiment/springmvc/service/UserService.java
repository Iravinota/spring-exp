package com.ws.experiment.springmvc.service;

import com.ws.experiment.springmvc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserService
 *
 * @author Eric at 2019-12-27_18:17
 */
public class UserService {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User getById(long id) {
        String sql = "select * from user where id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setName(resultSet.getString("name"));
            user.setAddr(resultSet.getString("addr"));
            return user;
        }
    }
}
