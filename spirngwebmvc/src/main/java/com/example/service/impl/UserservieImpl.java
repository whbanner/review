package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class UserservieImpl implements Userservice {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByNameAndPassword(String username,String password) {
        return userDao.findByUsernameAndPassword(username,password);
    }

    @Override
    public User findUserByName(String name){
        return userDao.findByUsername(name);
    }

    @Override
    public boolean register(User user) {
        if(findUserByName(user.getUsername())!=null){
            return true;
        }
//        //生产数据库唯一id
//        if (user.getID()==null||user.getID().equals("")){
//            user.setUsername(UUID.randomUUID().toString());
//        }

        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

        return userDao.insertUser(user)!=0;
    }
}
