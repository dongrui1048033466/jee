
package com.drsoft.JEE.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controllers {
    // 跳转到区域管理页面
    @RequestMapping("/test4")
    public String test4(){
        return "page/user/test4";
    }
    // 跳转到子系统设置页面
    @RequestMapping("/system1")
    public String system1(){
        return "page/system/system1";
    }
    // 跳转到权限管理页面
    @RequestMapping("/system2")
    public String system2(){
        return "page/system/system2";
    } // 跳转到数据字典页面
    @RequestMapping("/system3")
    public String system3(){
        return "page/system/system3";
    } // 跳转到节假日管理页面
    @RequestMapping("/system4")
    public String system4(){
        return "page/system/system4";
    }
}
