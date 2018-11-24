
package com.drsoft.JEE.controller;

import com.drsoft.JEE.pojo.Mechanism;
import com.drsoft.JEE.service.MechanismService;
import com.drsoft.JEE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MechanismController {
    @Autowired
    private MechanismService mechanismService;
    @Autowired
    private UserService userService;

    //    跳转机构管理页面
    @RequestMapping("/test3")
    public String queryuserAll( Model model,HttpSession session){
        List<Mechanism> list = mechanismService.queryAll();
//        System.out.println(list);
        int count = mechanismService.querycount();
        session.removeAttribute("loginName");
        session.removeAttribute("userName");
        session.setAttribute("count",count);
        model.addAttribute("list",list);

        return "page/user/test3";
    }
}
