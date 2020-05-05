package com.example.service;

import com.example.entity.User;

public interface UserService {

    User selectUser(Integer userId);

    int insertUser(User user);
}
