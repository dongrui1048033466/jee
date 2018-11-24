package com.drsoft.JEE.service.impl;



import com.drsoft.JEE.dao.RoleDao;
import com.drsoft.JEE.pojo.Role;
import com.drsoft.JEE.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
@Autowired
private RoleDao roleDao;

    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = false)
    public int add(Integer uId,Integer rId) {
        return roleDao.add( uId, rId);
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = false)
    public int addTorole(Role role ) {
        return roleDao.addTorole( role);
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = false)
    public int addByrole(Role role) {
        return roleDao.addByrole(role);
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public Role findRole(Integer uId) {
        Role role = this.roleDao.findRole(uId);
        return role;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public Role findRoleByrole(String role) {
        Role roles = this.roleDao.findRoleByrole(role);
        return roles;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = false)
    public int update(Integer uId,Integer rId,Integer u_rId)
    {
        return roleDao.update(uId,rId,u_rId);

    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = false)
    public int updateTorole(Role role)
    {
        return roleDao.updateTorole(role);

    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public List<Role> queryAll() {
        List<Role> rolelist = new ArrayList<Role>();
        rolelist = this.roleDao.queryAll();
        return rolelist;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public List<Role> queryAllTo() {
        List<Role> rolelist = new ArrayList<Role>();
        rolelist = this.roleDao.queryAllTo();
        return rolelist;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public List<Role> queryAllTojur() {
        List<Role> rolelist = new ArrayList<Role>();
        rolelist = this.roleDao.queryAllTojur();
        return rolelist;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = false)
    public int delete(int id) {
        return roleDao.delete(id);
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = false)
    public int deleteByrId(int rId) {
        return roleDao.deleteByrId(rId);
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = false)
    public int deleteTorId(int rId) {
        return roleDao.deleteTorId(rId);
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public int querycount() {
        int count = roleDao.querycount();
        return count;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public List<Role> getRoles(String Role) {
        List<Role> rolelist = new ArrayList<Role>();
        rolelist = roleDao.getRoles(Role);
        return rolelist;
    }
}
