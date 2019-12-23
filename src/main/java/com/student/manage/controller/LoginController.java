package com.student.manage.controller;

import com.student.manage.pojo.Information;
import com.student.manage.pojo.Login;
import com.student.manage.service.InformationserviceImpl;
import com.student.manage.service.LoginserviceImpl;
import com.student.manage.service.SignserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginserviceImpl loginservice;
    @Autowired
    private InformationserviceImpl informationservice;
    @Autowired
    private SignserviceImpl signservice;

    @RequestMapping(value = "/")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String index(@RequestParam("student_id")String student_id,@RequestParam("password")String loginPass,HttpSession session,Model model){
        Login login = loginservice.findloginuser(student_id);
        System.out.println("登录验证");
        if(login == null || "".equals(login)){
            model.addAttribute("error","系统无此用户！");
            return "login";
        }else if(loginPass.equals(login.getPassword())){
            session.setAttribute("student_id",student_id);
            if(login.getPermission().equals("1")){
                System.out.println("管理员登录");
                return "redirect:/adindex";
            }else{
                System.out.println("用户登录");
                return "redirect:/index";
            }
        }
        model.addAttribute("error","学号密码错误！");
        return "login";
    }
    @RequestMapping(value = "/registered",method = RequestMethod.GET)
    public String registered_get(){
        return "register";
    }
    @RequestMapping(value = "/registered",method = RequestMethod.POST)
    public String registered_post(@RequestParam("student_id")String student_id,@RequestParam("password")String password,@RequestParam("name")String name ,Model model){
        System.out.println("用户注册");
        loginservice.registered(student_id,password,name,"0");      //将信息存到数据库login表
        informationservice.preserveName(name,student_id);
        //signservice.preserveName(name);//将姓名存到information表，sign表
        model.addAttribute("successful","注册成功！");
        System.out.println("用户注册成功！");
        return "register";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute("student_id");
        return "login";
    }
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(Model model,HttpSession session,@RequestParam("oldpassword")String oldpassword,@RequestParam("password")String password,@RequestParam("repassword")String repassword){
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        if (password.equals(repassword) && oldpassword.equals(login.getPassword())){
            loginservice.changepassword(password,student_id);
            model.addAttribute("change","已修改成功，请重新登录");
            return "login";
        }
        //model.addAttribute("change1","修改失败请检查密码输入是否正确！");
        return "redirect:/table-list-img ";
    }
    @RequestMapping(value = "/adedit",method = RequestMethod.POST)
    public String adedit(Model model,HttpSession session,@RequestParam("oldpassword")String oldpassword,@RequestParam("password")String password,@RequestParam("repassword")String repassword){
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        if (password.equals(repassword) && oldpassword.equals(login.getPassword()) && password.length()>11){
            loginservice.changepassword(password,student_id);
            model.addAttribute("change","请重新登录");
            return "login";
        }
        //model.addAttribute("change1","修改失败请检查密码输入是否正确！");
        return "redirect:/adtable-list-img ";
    }
}
