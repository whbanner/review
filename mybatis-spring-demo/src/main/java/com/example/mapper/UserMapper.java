package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM test1 WHERE id = #{userId}")
    User selectUser(@Param("userId")Integer userId );

    @Insert("insert into test1(id,name,age) values(#{id},#{name},#{age})")
    public int insertUser(User user);
}
