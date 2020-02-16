package com.ws.exp.spring.mybatis.mapper;

import com.ws.exp.spring.mybatis.model.Coffee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * CoffeeMapper
 *
 * @author Eric at 2020-02-16_15:09
 */
@Repository     // 使用@Repository防止Application类中IDEA无法自动发现Autowied: <https://stackoverflow.com/questions/25379348/idea-inspects-batis-mapper-bean-wrong>
@Mapper
public interface CoffeeMapper {

    @Insert("insert into t_coffee (name, price, create_time, update_time) values (#{name}, #{price}, now(), now())")
    @Options(useGeneratedKeys = true)
    int save(Coffee coffee);

    @Select("select * from t_coffee where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            // map-underscore-to-camel-case = true 可以实现一样的效果
            // @Result(column = "create_time", property = "createTime"),
            // @Result(column = "update_time", property = "updateTime"),
    })
    Coffee findById(@Param("id") Long id);
}
