
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
public class RoleController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    //    跳转到角色管理页面
    @RequestMapping("/test2")
    public String queryuserAll( Model model,HttpSession session){
        List<Role> list = roleService.queryAllTo();
        System.out.println(list);
        List<User> userList = userService.queryAll();
        List<Role> jurlist = roleService.queryAllTojur();
        int count = roleService.querycount();
        session.removeAttribute("Role");
        session.setAttribute("count",count);
        session.setAttribute("jurlist",jurlist);
        model.addAttribute("list",list);
        model.addAttribute("userList",userList);
        return "page/user/test2";
    }
    //    模糊查询角色信息
    @RequestMapping("/getRoles")
    public String getRoles( String Role,Model model,HttpSession session){
        System.out.print(Role);
        List<Role> roleList   = roleService.getRoles(Role);

        int count = roleService.querycount();
        session.setAttribute("Role",Role);
        model.addAttribute("count",count);
        model.addAttribute("list",roleList);
        return "page/user/test2";
    }
    //   删除角色
    @RequestMapping("/role/delete.action")
    public String delete( int rId,Model model,HttpServletRequest request){

        roleService.deleteTorId(rId);
        roleService.deleteByrId(rId);
        String Role = (String) request.getSession(true).getAttribute("Role");
        if(Role!=null){
            List<Role> list   = roleService.getRoles(Role);
            model.addAttribute("list",list);

        }else{
            List<Role> list = roleService.queryAllTo();
            model.addAttribute("list",list);
        }
        int count = roleService.querycount();
        model.addAttribute("count",count);
        return "page/user/test2";
    }
    //在进行添加角色
    @RequestMapping("/role/add.action")
    public String useradds( String role,String content,Model model, HttpSession session,HttpServletRequest request
    ){
        Role roleS = new Role();
        roleS.setRole(role);
        roleS.setContent(content);

        int rows = roleService.addTorole(roleS);

        String langtype[]=request.getParameterValues("jId"); //用getParameterValues的方法，将核取到的值取到langtype[]阵列内
        if (langtype!=null)
        //前端的使用者,如果没打勾的话
        //request.getParameterValues("langtype")会接收到null值
        {
            Role role1 = roleService.findRoleByrole(role);
            Integer rId = role1.getrId();
            int size=java.lang.reflect.Array.getLength(langtype);
            //取得这个阵列大小
            for (int i=0;i<size;i++)
            {
                System.out.println(langtype[i]+"<br>");
                Integer jId =  Integer.parseInt(langtype[i]);
                Role role2 = new Role();
                role2.setrId(rId);
                role2.setjId(jId);
                roleService.addByrole(role2);
            }
            //利用一个for迴圈将阵列资料取出
        }
        else{
            List<Role> list = roleService.queryAllTo();

            int count = userService.querycount();
            model.addAttribute("count",count);
            model.addAttribute("list",list);
            return "page/user/test2";
        }

        List<Role> list = roleService.queryAllTo();

        int count = userService.querycount();
        model.addAttribute("count",count);
        model.addAttribute("list",list);
        return "page/user/test2";
    }
    //    在进行修改角色
    @RequestMapping("/role/update.action")
    public String update( String role,String content,Integer rId , Model model,HttpServletRequest request,HttpSession session
    ){
        Role roleS = new Role();
        roleS.setRole(role);
        roleS.setContent(content);
        roleS.setrId(rId);


        int rows = roleService.updateTorole(roleS);

        String Role = (String) request.getSession(true).getAttribute("Role");
        if(Role!=null){
            List<Role> list   = roleService.getRoles(Role);
            model.addAttribute("list",list);

        }else{
            List<Role> list = roleService.queryAllTo();
            model.addAttribute("list",list);
        }
        int count = userService.querycount();
        model.addAttribute("count",count);
        return "page/user/test2";
    }
    //修改角色权限
    @RequestMapping("/role/updateTojur.action")
    public String useradds( Integer rId,Model model, HttpSession session,HttpServletRequest request
    ){

        String langtype[]=request.getParameterValues("jId"); //用getParameterValues的方法，将核取到的值取到langtype[]阵列内
        if (langtype!=null)
        //前端的使用者,如果没打勾的话
        //request.getParameterValues("langtype")会接收到null值
        {
            roleService.deleteTorId(rId);
            int size=java.lang.reflect.Array.getLength(langtype);
            //取得这个阵列大小
            for (int i=0;i<size;i++)
            {
                System.out.println(langtype[i]+"<br>");
                Integer jId = Integer.parseInt(langtype[i]);
                Role role = new Role();
                role.setrId(rId);
                role.setjId(jId);

                roleService.addByrole(role);
            }
            //利用一个for迴圈将阵列资料取出
        }
        else{
            List<Role> list = roleService.queryAllTo();

            int count = userService.querycount();
            model.addAttribute("count",count);
            model.addAttribute("list",list);
            return "page/user/test2";
        }

        String Role = (String) request.getSession(true).getAttribute("Role");
        if(Role!=null){
            List<Role> list   = roleService.getRoles(Role);
            model.addAttribute("list",list);

        }else{
            List<Role> list = roleService.queryAllTo();
            model.addAttribute("list",list);
        }
        int count = userService.querycount();
        model.addAttribute("count",count);
        return "page/user/test2";
    }
}

