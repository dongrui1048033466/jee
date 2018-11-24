package com.drsoft.JEE.service;


import com.drsoft.JEE.pojo.Mechanism;

import java.util.List;

public interface MechanismService {
    public List<Mechanism> queryAll();
    public int querycount();
}
