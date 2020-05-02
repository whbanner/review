package com.example.controller;

import com.example.entity.User;
import com.example.service.impl.UserservieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    private UserservieImpl userservie;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    @ResponseBody //controller返回值有两种 如果返回字符串加这个，如果返回页面地址就不用加
    public String hello(){

        return "hello";
    }
    //produce 参数解决 乱码，规定返回值类型
    @RequestMapping(value = "login",method = RequestMethod.POST,produces =  "application/json;charset=UTF-8")
    @ResponseBody
    public String login(String username,String password){
        User user=userservie.findUserByNameAndPassword(username, DigestUtils.md5DigestAsHex(password.getBytes()));
        if (user==null){
            return "用户名不存在或密码错误";
        }
        return "hello"+user.getUsername();
    }
    @RequestMapping(value = "registry",method = RequestMethod.POST)
    @ResponseBody
    public String registry(User user){
        boolean register=userservie.register(user);
        if (register){
            return "hello"+user.getUsername();
        }
        return "注册失败";

    }


}
