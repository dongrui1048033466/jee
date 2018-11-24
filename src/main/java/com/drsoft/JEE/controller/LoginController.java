package com.drsoft.JEE.controller;

import com.drsoft.JEE.pojo.Role;
import com.drsoft.JEE.pojo.User;
import com.drsoft.JEE.service.RoleService;
import com.drsoft.JEE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

//    登录
    @RequestMapping("/login")
    public String Login(HttpServletRequest request,Model model){
        User user=(User) request.getSession(true).getAttribute("user");//session中的验
        model.addAttribute("user",user);
        return "login";
    }
//zhuce
    @RequestMapping("/zhuce")
    public String Zhuce(Model model){
        List<Role> roleList = roleService.queryAll();
        model.addAttribute("roleList",roleList);
        return "zhuce";
    }
//    @RequestMapping("/shenhe")
//    public String shenhe(){
//        return "shenhe";
//    }
    @RequestMapping("/index")
    public String Index(){
        return "page/index";
    }

    @RequestMapping("/home")
    public String Home(){
        return "page/home";
    }

    @RequestMapping(value="/userLogin.action",method = RequestMethod.POST )
    public String userLogin(String usercode, String loginName, String loginPwd, Model model, HttpServletRequest request, HttpSession session){
        User user = userService.findUser(loginName,loginPwd);

        String realcode=(String) request.getSession(true).getAttribute("realcode");//session中的验证码
       if(!realcode.equalsIgnoreCase(usercode)) {
           model.addAttribute("msg", "验证码输入错误");
           return "login";
       }
       else
       {
           if(user == null){
               model.addAttribute("msg", "用户名或密码输入错误！");
               return "login";
           }
       }
        if (user.getIsDelete() == 0) {
            model.addAttribute("msg", "该用户未审核！");
            return "login";
        }else if (user.getIsDelete() == 1) {
            model.addAttribute("msg", "该用户审核不通过,请修改！");
            model.addAttribute("user",user);
            List<Role> roleList = roleService.queryAll();
            model.addAttribute("roleList",roleList);
            return "zhucelist";
        }else{
           session.setAttribute("LOGIN_USER",user);
            return "page/index";
        }

    }
}

