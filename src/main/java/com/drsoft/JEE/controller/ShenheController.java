package com.drsoft.JEE.controller;

import com.drsoft.JEE.pojo.Role;
import com.drsoft.JEE.pojo.User;
import com.drsoft.JEE.service.RoleService;
import com.drsoft.JEE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class ShenheController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


//    跳转审核页面
    @RequestMapping("/user/test5")
    public String queryAll( Model model,HttpServletRequest request){
        List<User> list = userService.queryAll();
        User user = (User) request.getSession(true).getAttribute("LOGIN_USER");
        Integer id = user.getId();
        User user1 = userService.queryjurById(id);
        String jId = user1.getjIds();
        String [] jIds = jId.split(",");
        String jur = null;
        System.out.print(jIds);
//        判断权限
            for (int i = 0; i < jIds.length; i++) {
                System.out.println(jIds[i] + "<br>");
                if (Integer.parseInt(jIds[i]) == 2) {
                    int count = userService.querycount();
                    model.addAttribute("count", count);
                    model.addAttribute("list", list);
                    jur = "true";

                }
            }

            if(jur == "true"){
                int count = userService.querycount();
                model.addAttribute("count", count);
                model.addAttribute("list", list);
                return "page/user/test5";
            }else {
                return "page/jurisdiction";
            }
//            int count = userService.querycount();
//            model.addAttribute("count",count);
//            model.addAttribute("list",list);
//            return "page/user/test5";
//
//            return "page/jurisdiction";

    }
//进行审核
    @RequestMapping("/user/shenhe.action")
    public String shenhe( String loginName,String userName,Integer id,Integer isDelete,Model model,HttpServletRequest request
    ){
        User user = (User) request.getSession(true).getAttribute("LOGIN_USER");
        Integer ids = user.getId();
        User user1 = userService.queryjurById(ids);
        String jId = user1.getjIds();
        String [] jIds = jId.split(",");
        String jur = null;
        System.out.print(jIds);
//        判断权限
        for (int i = 0; i < jIds.length; i++) {
            System.out.println(jIds[i] + "<br>");
            if (Integer.parseInt(jIds[i]) == 6) {
                jur = "true";
            }
        }
        if(jur == "true"){

            User users = new User();
            users.setId(id);
            users.setIsDelete(isDelete);
            int rows = userService.update(users);
            List<User> list   = userService.getUsers(loginName,userName);
            model.addAttribute("list",list);
            model.addAttribute("loginName",loginName);
            model.addAttribute("userName",userName);
            return "page/user/test5";
        }else{
            List<User> list   = userService.getUsers(loginName,userName);
            model.addAttribute("list",list);
            model.addAttribute("loginName",loginName);
            model.addAttribute("userName",userName);
            model.addAttribute("msg","你没有权限进行修改！");
            return "page/jurisdiction";
        }

    }
//用户刷新审核
    @RequestMapping("shenhe.action")
    public String shenhes( Integer id,Model model,HttpSession session
    ){
        System.out.println(id+"  "
        );
        User user = userService.queryById(id);
       if(user.getIsDelete()==0){
           model.addAttribute("msg","还没有进行审核!");
           return "shenhe";
       }else if(user.getIsDelete()==1){
           model.addAttribute("user",user);
           model.addAttribute("msg","该用户审核不通过,请修改！");
           List<Role> roleList = roleService.queryAll();
           model.addAttribute("roleList",roleList);
           return "zhucelist";
       }else{
           session.setAttribute("user",user);
           return"success";
       }


    }
//    检查
    @RequestMapping("/check")
    @ResponseBody
    public String check(String type, String value,Model model){
        User user = new User();
        if(type.equals("loginName")){
             user = userService.queryByLoginName(value);
        }else{
             user = userService.queryByEmail(value);
        }
        String reStr="true";
        if(user != null){
            reStr="false";
        }
     return reStr;
    }

//    @RequestMapping("/user/queryById.action")
//    public String queryById( int id,Model model){
//        User user = userService.queryById(id);
//        System.out.println(user);
//        model.addAttribute("user",user);
//        return "/system/user/updateuser";
//    }

//    审核不通过的进行修改
    @RequestMapping("update.action")
    public String update( Integer id,String loginName, String loginPwd, String userName,String phone,
                          String email,String idCard,Integer rId, Integer sex, Model model,HttpSession session
    ){
        System.out.println(id+" "+loginName+" "+loginPwd+" "
                + email+" "+sex+" "
        );
        User user = new User();
        user.setId(id);
        user.setLoginName(loginName);
        user.setLoginPwd(loginPwd);
        user.setUserName(userName);
        user.setPhone(phone);
        user.setrIds(rId);
        user.setEmail(email);
        user.setSex(sex);
        user.setIdCard(idCard);

        Integer uId =id;
        Role role = roleService.findRole(uId);
        Integer u_rId = role.getU_rId();
        roleService.update(uId,rId,u_rId);
        int rows = userService.update(user);
        session.setAttribute("user",user);
        List<Role> roleList = roleService.queryAll();
        model.addAttribute("roleList",roleList);
        return "shenhe";
    }
//进行注册
    @RequestMapping("adds.action")
    public String useradd(  String loginName, String loginPwd, String userName, String phone,
                              String email,String idCard,Integer rId, Integer sex, Model model, HttpSession session
    ){
        System.out.println(loginName+" "+loginPwd+" "+phone+" "
                + email+" "+sex+" "
        );
        User user = new User();
        user.setLoginName(loginName);
        user.setLoginPwd(loginPwd);
        user.setUserName(userName);
        user.setPhone(phone);
        user.setEmail(email);
        user.setSex(sex);
        user.setrIds(rId);
        user.setIdCard(idCard);

        Role role = new Role();

        int rows = userService.add(user);

        User users = userService.findUsers(loginName,loginPwd);
        Integer uId = users.getId();

        roleService.add(uId,rId);
        User user1 = userService.findUser(loginName,loginPwd);
        session.setAttribute("user",user1);

        List<Role> roleList = roleService.queryAll();
        model.addAttribute("roleList",roleList);
        return "shenhe";
    }

    @RequestMapping("/add.action")
    @ResponseBody
    public String useradds(  String loginNames, String loginPwds, String userName, String phone,
                           String email,  Integer sex,String headImg,
                           Integer age, Integer user_type_id,
                           Integer isDelete,Model model
    ){
        System.out.println(loginNames+" "+loginPwds+" "+phone+" "
                + email+" "+sex+" " +age+" "+user_type_id
        );
        User user = new User();
        user.setLoginName(loginNames);
        user.setLoginPwd(loginPwds);
        user.setUserName(userName);
        user.setPhone(phone);
        user.setEmail(email);
        user.setSex(sex);

        int rows = userService.add(user);
        List<User> list = userService.queryAll();
        model.addAttribute("list",list);
        String reStr="{\"status\":false}";
        if(true){
            reStr="{\"status\":true}";
        }

        return reStr;
    }

//    @RequestMapping("/user/delete.action")
//    public String delete( int id,Model model){
//        userService.delete(id);
//        List<User> list = userService.queryAll();
//        model.addAttribute("list",list);
//        return "system/user/userlist";
//    }
//    模糊查询
    @RequestMapping("/getUsers")
    public String getUsers( String loginName, String userName,Model model){
        System.out.print(loginName+"  "+userName);
        List<User> userlist   = userService.getUsers(loginName,userName);

       int count = userService.querycount();
        model.addAttribute("loginName",loginName);
        model.addAttribute("userName",userName);
        model.addAttribute("count",count);
        model.addAttribute("list",userlist);
        return "page/user/test5";

    }
}
