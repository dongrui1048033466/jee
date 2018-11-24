package com.drsoft.JEE.dao;

import com.drsoft.JEE.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
//    通过账号和密码查用户
    public User findUser(@Param("loginName") String loginName,
                         @Param("loginPwd") String loginPwd);
//    通过账号和密码查用户
    public User findUsers(@Param("loginName") String loginName,
                         @Param("loginPwd") String loginPwd);
//    查总数
    public int querycount();
//全查用户
    public List<User> queryAll();
//更新用户
    public int update(User user);
//删除用户
    public int delete(@Param("id") int id);
//添加用户
    public int add(User User);
//通过id查用户
    public User queryById(@Param("id") int id);
//通过id查用户权限
    public User queryjurById(@Param("id") int id);

//    通过email查
    public User queryByEmail(@Param("value") String email);
//    通过loginName查
    public User queryByLoginName(@Param("value") String loginName);

    //模糊查询
    public List<User> getUsers(@Param("loginName") String loginName, @Param("userName") String userName);
}
