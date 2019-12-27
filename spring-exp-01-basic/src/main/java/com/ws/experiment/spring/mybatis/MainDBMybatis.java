package com.ws.experiment.spring.mybatis;

import com.ws.experiment.spring.basic.User;
import com.ws.experiment.spring.mybatis.dao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * MainDB
 *
 * @author Eric at 2019-12-26_19:32
 */
public class MainDBMybatis {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/db/db-mybatis-transaction.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);
        List<User> users = userDao.getAllUsers();
        System.out.println("mybatis datas");
        System.out.println(users);

        context.close();
    }
}
