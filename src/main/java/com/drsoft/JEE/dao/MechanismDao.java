package com.drsoft.JEE.dao;


import com.drsoft.JEE.pojo.Mechanism;

import java.util.List;

public interface MechanismDao {
    //全查用户
    public List<Mechanism> queryAll();
    //    查总数
    public int querycount();
}
