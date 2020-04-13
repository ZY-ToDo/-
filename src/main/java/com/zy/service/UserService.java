package com.zy.service;

import com.zy.domain.PageBean;
import com.zy.domain.User;
import com.zy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findUser() {
        return userMapper.selectUser();
    }

    public void delete(int id){userMapper.deleteUser(id);}


    public PageBean<User> findUserByPage(Integer currentPage, Integer pageSize) {
        PageBean<User> pagebean = new PageBean<User>();
        System.out.println("service中的currentPage为："+currentPage+",pageSize为"+pageSize);
        pagebean.setCurrentPage(currentPage);
        pagebean.setPageSize(pageSize);

        Integer startRow = pageSize*(currentPage-1);    //数据库中起始行
        int count = userMapper.selectUserCount();   //用户总数
        int totalPage = (int) Math.ceil(count*1.0/pageSize);

        List<User> users = userMapper.selectUserByPage(startRow, pageSize);
        pagebean.setCount(count);
        pagebean.setUserList(users);
        pagebean.setTotalPage(totalPage);
        return pagebean;
    }
}
