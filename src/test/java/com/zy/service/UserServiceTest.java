package com.zy.service;


import com.zy.domain.PageBean;
import com.zy.domain.User;
import com.zy.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @org.junit.Test
    public void findUser() {
        List<User> list = userService.findUser();
        System.out.println(list.toString());
    }

    @org.junit.Test
    public void delete() {
    }

    @Test
    public void findUserByPage() {
        PageBean<User> userByPage = userService.findUserByPage(1, 5);
        System.out.println(userByPage.toString());
    }
}
