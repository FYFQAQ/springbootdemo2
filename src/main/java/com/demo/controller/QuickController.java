package com.demo.controller;

import com.demo.domain.User;
import com.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuickController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/quick2")
    public String aaa() {
        return "东汇顶科狂欢节方道";
    }

    @RequestMapping("/query")
    public List<User> query(){
        List<User> users = userMapper.queryUserList ();
        return users;
    }
}
