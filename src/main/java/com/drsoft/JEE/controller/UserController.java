package com.drsoft.JEE.controller;

import com.drsoft.JEE.pojo.Role;
import com.drsoft.JEE.pojo.User;
import com.drsoft.JEE.service.RoleService;
import com.drsoft.JEE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    //    跳转用户管理页面
    @RequestMapping("test1")
    public String queryuserAll( Model model,HttpSession session){
        List<User> list = userService.queryAll();
        System.out.println(list);
        List<Role> roleList = roleService.queryAll();
        int count = userService.querycount();
        session.removeAttribute("loginName");
        session.removeAttribute("userName");
        session.setAttribute("count",count);
        model.addAttribute("list",list);
        session.setAttribute("roleList",roleList);
        return "page/user/test1";
    }
    //    模糊查询
    @RequestMapping("/getUserRoles")
    public String getUsers( String loginName, String userName,Model model,HttpSession session){
        System.out.print(loginName+"  "+userName);
        List<User> userlist   = userService.getUsers(loginName,userName);


        session.setAttribute("loginName",loginName);
        session.setAttribute("userName",userName);

        model.addAttribute("list",userlist);
        return "page/user/test1";
    }
//   删除用户
    @RequestMapping("/user/delete.action")
    public String delete( int id,HttpServletRequest request,Model model){

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
            if (Integer.parseInt(jIds[i]) == 4) {
                jur = "true";
            }
        }
        if(jur == "true"){
            userService.delete(id);
//        List<User> list = userService.queryAll();
            String loginName = (String) request.getSession(true).getAttribute("loginName");
            String userName = (String) request.getSession(true).getAttribute("userName");
            if(loginName != null && userName !=null) {
                List<User> list = userService.getUsers(loginName, userName);
                model.addAttribute("list",list);
            }    else{
                List<User> list = userService.queryAll();
                model.addAttribute("list",list);
            }
            return "page/user/test1";
        }else {
            List<User> list = userService.queryAll();
            model.addAttribute("list",list);
            model.addAttribute("msg","你没有权限进行删除!");
            return "page/jurisdiction";
        }


    }
//在用户管理页面里面进行添加用户
    @RequestMapping("/user/add.action")
    public String useradds( String loginName, String loginPwd, String userName, String phone,
                            String email,String idCard,Integer rId, Integer sex, Model model, HttpSession session,HttpServletRequest request
    ){

//        判断权限
        User users = (User) request.getSession(true).getAttribute("LOGIN_USER");
        Integer ids = users.getId();
        User user1 = userService.queryjurById(ids);
        String jId = user1.getjIds();
        String [] jIds = jId.split(",");
        String jur = null;
        System.out.print(jIds);
        for (int i = 0; i < jIds.length; i++) {
            System.out.println(jIds[i] + "<br>");
            if (Integer.parseInt(jIds[i]) == 3) {
                jur = "true";
            }
        }
        if(jur == "true"){
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
            User user2 = userService.findUsers(loginName,loginPwd);
            Integer uId = user2.getId();
            roleService.add(uId,rId);
//            User user2 = userService.findUser(loginName,loginPwd);
//            session.setAttribute("user",user2);
            List<User> list = userService.queryAll();
            model.addAttribute("list",list);
            return "page/user/test1";
        }else {
            String loginNames = (String) request.getSession(true).getAttribute("loginName");
            String userNames = (String) request.getSession(true).getAttribute("userName");
            if(loginNames != null && userNames !=null) {
                List<User> list = userService.getUsers(loginNames, userNames);
                model.addAttribute("list",list);
            }  else{
                List<User> list = userService.queryAll();
                model.addAttribute("list",list);
            }
//        List<User> list = userService.queryAll();
            int count = userService.querycount();
            model.addAttribute("count",count);
            model.addAttribute("msg","你没有权限进行添加！");
            return "page/jurisdiction";
        }

    }
//    在用户管理界面进行修改
    @RequestMapping("/user/update.action")
    public String update( Integer id,String loginName, String loginPwd, String userName,String phone,
                          String email,String idCard,Integer isDelete ,  Model model,HttpSession session,HttpServletRequest request
    ){

        User users = (User) request.getSession(true).getAttribute("LOGIN_USER");
        Integer ids = users.getId();
        User user1 = userService.queryjurById(ids);
        String jId = user1.getjIds();
        String [] jIds = jId.split(",");
        String jur = null;
        System.out.print(jIds);
//        判断权限
        for (int i = 0; i < jIds.length; i++) {
            System.out.println(jIds[i] + "<br>");
            if (Integer.parseInt(jIds[i]) == 5) {
                jur = "true";

            }
        }
        if(jur == "true"){
            User user = new User();
            user.setId(id);
            user.setLoginName(loginName);
            user.setUserName(userName);
            user.setLoginPwd(loginPwd);
            user.setPhone(phone);
            user.setEmail(email);
            user.setIdCard(idCard);
            user.setIsDelete(isDelete);


            int rows = userService.update(user);
            session.setAttribute("user",user);
            String loginNames = (String) request.getSession(true).getAttribute("loginName");
            String userNames = (String) request.getSession(true).getAttribute("userName");
            if(loginNames != null && userNames !=null) {
                List<User> list = userService.getUsers(loginName, userName);
                model.addAttribute("list",list);
            }  else{
                List<User> list = userService.queryAll();
                model.addAttribute("list",list);
            }
//        List<User> list = userService.queryAll();
            int count = userService.querycount();
            model.addAttribute("count",count);

            return "page/user/test1";
        }else {
            String loginNames = (String) request.getSession(true).getAttribute("loginName");
            String userNames = (String) request.getSession(true).getAttribute("userName");
            if(loginNames != null && userNames !=null) {
                List<User> list = userService.getUsers(loginNames, userNames);
                model.addAttribute("list",list);
            }  else{
                List<User> list = userService.queryAll();
                model.addAttribute("list",list);
            }
//        List<User> list = userService.queryAll();
            int count = userService.querycount();
            model.addAttribute("count",count);
            model.addAttribute("msg","你没有权限进行修改！");
            return "page/jurisdiction";
        }





    }
//    对用户进行角色分配
@RequestMapping("updateToRole.action")
public String update( Integer id,HttpServletRequest request, Model model,HttpSession session
){
//        判断权限
    User user = (User) request.getSession(true).getAttribute("LOGIN_USER");
    Integer ids = user.getId();
    User user1 = userService.queryjurById(ids);
    String jId = user1.getjIds();
    String [] jIds = jId.split(",");
    String jur = null;
    System.out.print(jIds);

    for (int i = 0; i < jIds.length; i++) {
        System.out.println(jIds[i] + "<br>");
        if (Integer.parseInt(jIds[i]) == 5) {
            jur = "true";

        }
    }
    if(jur == "true"){
        String langtype[]=request.getParameterValues("rId"); //用getParameterValues的方法，将核取到的值取到langtype[]阵列内
        if (langtype!=null)
        //前端的使用者,如果没打勾的话
        //request.getParameterValues("langtype")会接收到null值
        {
            roleService.delete(id);
            int size=java.lang.reflect.Array.getLength(langtype);
            //取得这个阵列大小
            for (int i=0;i<size;i++)
            {
                System.out.println(langtype[i]+"<br>");
                Integer rId =  Integer.parseInt(langtype[i]);
                Integer uId = id;
                roleService.add(uId,rId);
            }
            //利用一个for迴圈将阵列资料取出
        }
        else{
//        List<User> list = userService.queryAll();
            String loginName = (String) request.getSession(true).getAttribute("loginName");
            String userName = (String) request.getSession(true).getAttribute("userName");
            if(loginName != null && userName !=null) {
                List<User> list = userService.getUsers(loginName, userName);
                model.addAttribute("list",list);
            } else{
                List<User> list = userService.queryAll();
                model.addAttribute("list",list);
            }
            int count = userService.querycount();
            List<Role> roleList = roleService.queryAll();
            model.addAttribute("count",count);
            session.setAttribute("roleList",roleList);
            return "page/user/test1";
        }

//    List<User> list = userService.queryAll();
        String loginName = (String) request.getSession(true).getAttribute("loginName");
        String userName = (String) request.getSession(true).getAttribute("userName");
        if(loginName != null && userName !=null) {
            List<User> list = userService.getUsers(loginName, userName);
            model.addAttribute("list",list);
        } else{
            List<User> list = userService.queryAll();
            model.addAttribute("list",list);
        }
        int count = userService.querycount();
        List<Role> roleList = roleService.queryAll();
        model.addAttribute("count",count);
        session.setAttribute("roleList",roleList);
        return "page/user/test1";
    }else {
        String loginNames = (String) request.getSession(true).getAttribute("loginName");
        String userNames = (String) request.getSession(true).getAttribute("userName");
        if(loginNames != null && userNames !=null) {
            List<User> list = userService.getUsers(loginNames, userNames);
            model.addAttribute("list",list);
        }  else{
            List<User> list = userService.queryAll();
            model.addAttribute("list",list);
        }
//        List<User> list = userService.queryAll();
        int count = userService.querycount();
        model.addAttribute("count",count);
        model.addAttribute("msg","你没有权限进行修改！");
        return "page/jurisdiction";
    }

}
}

