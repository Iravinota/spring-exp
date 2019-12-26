package com.ws.experiment.spring.annotation;

import com.ws.experiment.spring.basic.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试使用annotation方式开发的Spring程序
 *
 * @author Eric at 2019-12-26_16:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class BeanTest {

    @Autowired
    private String str;

    @Autowired
    private User user;

    @Autowired
    private Teacher teacher;

    @Test
    public void testStr() {
        Assert.assertEquals("A String", str);
    }

    @Test
    public void testUser() {
        System.out.println(user);
        Assert.assertEquals("AAA", user.getName());
        Assert.assertEquals("BBB", user.getAddr());
    }

    @Test
    public void testTeacher() {
        Assert.assertNotNull(teacher);
        System.out.println(teacher);
        Assert.assertEquals("Good", teacher.getId());
        Assert.assertEquals("Dr.", teacher.getTitle());
    }
}
