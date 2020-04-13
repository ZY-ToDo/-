package com.zy.mapper;

import com.zy.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> selectUser();

    void deleteUser(int id);


    Integer selectUserCount();

    List<User> selectUserByPage(@Param(value = "startRow") Integer startRow,
                                @Param(value = "pageSize") Integer pageSize);
}
