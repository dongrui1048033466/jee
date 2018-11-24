package com.drsoft.JEE.controller;

import com.drsoft.JEE.pojo.User;
import com.drsoft.JEE.service.UserService;
import com.drsoft.JEE.utils.ExclesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;



@Controller
public class ExcleController {
    //这里直接new了
    ExclesImpl  exclesImpl=new ExclesImpl();
    @Autowired
    private UserService userService;

    //    表格
    @RequestMapping("/exportexcel")
    public String Login(){
        return "exportexcel";
    }

    @RequestMapping(value="/jsp/download_excel")

//获取url链接上的参数
    public @ResponseBody String dowm(HttpServletResponse response){
        response.setContentType("application/binary;charset=UTF-8");
        try{
            ServletOutputStream out=response.getOutputStream();
            try {
                //设置文件头：最后一个参数是设置下载文件名(这里我们叫：xx.pdf)
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("name"+".xls", "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            List<User> list = userService.queryAll();
            String[] titles = { "ID", "登录名", "姓名", "手机" ,"邮箱","身份证号码","角色","加入时间"};
            exclesImpl.export(titles,list, out);
            return "success";
        } catch(Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }

}