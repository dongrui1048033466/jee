package com.drsoft.JEE.service.impl;


import com.drsoft.JEE.dao.UserDao;
import com.drsoft.JEE.pojo.User;
import com.drsoft.JEE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
@Autowired
private UserDao userDao;

    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public User findUser(String loginName, String loginPwd) {
        User user = this.userDao.findUser(loginName,loginPwd);
        return user;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public User findUsers(String loginName, String loginPwd) {
        User user = this.userDao.findUsers(loginName,loginPwd);
        return user;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public List<User> queryAll() {
        List<User> userlist = new ArrayList<User>();
        userlist = this.userDao.queryAll();
        return userlist;
    }

    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public User queryById(int id) {
        User user = new User();
        user = userDao.queryById(id);
        return user;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public User queryjurById(int id) {
        User user = new User();
        user = userDao.queryjurById(id);
        return user;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public User queryByEmail(String email) {
        User user = new User();
        user = userDao.queryByEmail(email);
        return user;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public User queryByLoginName(String loginName) {
        User user = new User();
        user = userDao.queryByLoginName(loginName);
        return user;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public int querycount() {
        int count = userDao.querycount();
        return count;
    }

    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = false)
    public int update(User user)
    {
        return userDao.update(user);

    }

    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = false)
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = false)
    public int add(User User) {
        return userDao.add(User);
    }

    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public List<User> getUsers(String conditions, String keyword) {
        List<User> userlist = new ArrayList<User>();
        userlist = userDao.getUsers(conditions,keyword);
        return userlist;
    }
}
