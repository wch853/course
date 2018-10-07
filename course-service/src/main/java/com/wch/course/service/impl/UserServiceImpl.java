package com.wch.course.service.impl;

import com.wch.course.dao.IUserDao;
import com.wch.course.thrift.domain.UserInfo;
import com.wch.course.thrift.service.IUserService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService.Iface {

    @Resource
    private IUserDao userDao;

    @Override
    public UserInfo queryUserById(int id) throws TException {
        return userDao.selectUserById(id);
    }

    @Override
    public UserInfo queryUserByName(String username) throws TException {
        return userDao.selectUserByName(username);
    }

    @Override
    public void addUser(UserInfo userInfo) throws TException {
        userDao.insertUser(userInfo);
    }
}
