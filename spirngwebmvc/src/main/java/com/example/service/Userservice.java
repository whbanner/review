package com.example.service;

import com.example.entity.User;

public interface Userservice {
    User findUserByNameAndPassword(String username,String password);

    User findUserByName(String name);

    boolean register(User user);

}
