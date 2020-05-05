package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(Integer userId) {
        return userMapper.selectUser(userId);
    }

    @Override
    public int insertUser(User user) {
        userMapper.insertUser(user);
        return 0;
    }
}
