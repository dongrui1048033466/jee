package com.drsoft.JEE.service;

import com.drsoft.JEE.pojo.User;

import java.util.List;

public interface UserService {
    public User findUser(String usercode, String password);
    public User findUsers(String usercode, String password);

    public List<User> queryAll();
    public User queryById(int id);
    public User queryjurById(int id);
    public int querycount();
    public User queryByEmail(String email);
    public User queryByLoginName(String LoginName);
    public int update(User User);
    public int delete(int id);
    public int add(User User);
    public List<User> getUsers(String conditions, String keyword);
}
