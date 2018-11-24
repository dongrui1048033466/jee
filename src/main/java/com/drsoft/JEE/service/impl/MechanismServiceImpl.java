package com.drsoft.JEE.service.impl;


import com.drsoft.JEE.dao.MechanismDao;
import com.drsoft.JEE.pojo.Mechanism;
import com.drsoft.JEE.service.MechanismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MechanismServiceImpl implements  MechanismService {
@Autowired
private MechanismDao mechanismDao;
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public List<Mechanism> queryAll() {
        List<Mechanism> mechanismList = new ArrayList<Mechanism>();
        mechanismList = this.mechanismDao.queryAll();
        return mechanismList;
    }
    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,readOnly = true)
    public int querycount() {
        int count = mechanismDao.querycount();
        return count;
    }
}
