package com.ws.experiment.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Teacher
 *
 * @author Eric at 2019-12-26_16:26
 */
@Component
public class Teacher {

    // 有歧义时，使用限定符
    // 不推荐使用field injection
//    @Autowired
//    @Qualifier("id")
    private String id;

//    @Autowired
//    @Qualifier("title")
    private String title;

    public String getId() {
        return id;
    }

    @Autowired
    @Qualifier("id")
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @Autowired
    @Qualifier("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
