package com.wch.course.dao;

import com.wch.course.thrift.domain.UserInfo;

public interface IUserDao {

    UserInfo selectUserById(int id);

    UserInfo selectUserByName(String username);

    int insertUser(UserInfo userInfo);
}
