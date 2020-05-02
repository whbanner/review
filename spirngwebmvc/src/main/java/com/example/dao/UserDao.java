package com.example.dao;

import com.example.entity.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByUsername(String username){

        User user=new User();
        String sql="select * from login where username=? ";
        jdbcTemplate.query(sql, new Object[]{username}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUsername(resultSet.getString(1));
            }
        });
        return user;
    }

    public User findByUsernameAndPassword(String username,String password){

        User user=new User();
        String sql="select * from login where username=? AND password=?";
        jdbcTemplate.query(sql, new Object[]{username,password}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
            }
        });
        return user;
    }
    public int insertUser(User user){
            String sql="insert into login(username,password) values(?,?)";
            return jdbcTemplate.update(sql,user.getUsername(),user.getPassword());
    }
}
