package com.wch.course.dao.impl;

import com.wch.course.dao.IUserDao;
import com.wch.course.domain.thrift.UserInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl implements IUserDao {

    @Resource
    private SqlSessionTemplate sst;

    @Override
    public UserInfo selectUserById(int id) {
        return sst.selectOne("user.selectUserById", id);
    }

    @Override
    public UserInfo selectUserByName(String username) {
        return sst.selectOne("user.selectUserByName", username);
    }

    @Override
    public int insertUser(UserInfo userInfo) {
        return sst.insert("user.insertUser", userInfo);
    }
}
