package com.drsoft.JEE.dao;

import com.drsoft.JEE.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    //添加用户的角色
    public int add(@Param("uId")Integer uId, @Param("rId")Integer rId);
    //添加角色
    public int addTorole(Role role);
    //添加角色与权限关系
    public int addByrole(Role role);
    //更新用户
    public int update(@Param("uId")Integer uId, @Param("rId")Integer rId,@Param("u_rId")Integer u_rId);
    //更新角色
    public int updateTorole(Role role);
//    查询角色
    public Role findRole(@Param("uId")Integer uId);
    // 查询角色通过名字
    public Role findRoleByrole(@Param("role")String role);
    //全查角色
    public List<Role> queryAll();
    //全查权限
    public List<Role> queryAllTojur();
    //全查角色与权限
    public List<Role> queryAllTo();
//    删除分配的角色
    public int delete(@Param("id") int id);
//    删除分配的角色的权限
    public int deleteByrId(@Param("rId") int rId);
//    删除关联关系
    public int deleteTorId(@Param("rId") int rId);
//    查总数
    public int querycount();

    //模糊查询
    public List<Role> getRoles(@Param("Role") String Role);
}
