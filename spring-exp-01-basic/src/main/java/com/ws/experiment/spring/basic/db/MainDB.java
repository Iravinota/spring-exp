package com.ws.experiment.spring.basic.db;

import com.ws.experiment.spring.basic.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * MainDB
 *
 * @author Eric at 2019-12-26_19:32
 */
public class MainDB {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/db/datasource.xml");

        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from user";
        List<User> users = template.query(sql, new UserMapper());
        System.out.println(users);

        context.close();
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
