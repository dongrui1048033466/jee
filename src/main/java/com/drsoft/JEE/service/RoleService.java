package com.drsoft.JEE.service;

import com.drsoft.JEE.pojo.Role;

import java.util.List;

public interface RoleService {

    public int add(Integer uId,Integer rId);
    public int addByrole(Role role);
    public int addTorole(Role role);
    public int update(Integer uId,Integer rId,Integer u_rId);
    public int updateTorole(Role role);
    public Role findRole(Integer uId);
    public Role findRoleByrole(String role);
    public List<Role> queryAll();
    public List<Role> queryAllTojur();
    public List<Role> queryAllTo();
    public int querycount();
    public int delete(int id);
    public int deleteByrId(int rId);
    public int deleteTorId(int rId);
    public List<Role> getRoles(String Role);
}
