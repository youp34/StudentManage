package com.student.manage.controller;

import com.student.manage.pojo.Information;
import com.student.manage.pojo.Login;
import com.student.manage.pojo.Sign_in;
import com.student.manage.service.InformationserviceImpl;
import com.student.manage.service.LoginserviceImpl;
import com.student.manage.service.NoticeserviceImpl;
import com.student.manage.service.SignserviceImpl;
import com.student.manage.tool.time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Admin_indexController {
    @Autowired
    InformationserviceImpl informationservice;
    @Autowired
    LoginserviceImpl loginservice;
    @Autowired
    SignserviceImpl signservice;
    @Autowired
    NoticeserviceImpl noticeservice;

    time time = new time();
    @RequestMapping(value = "/adindex")
    public String index(Model model, HttpSession session){                                                              //首页
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        List people = informationservice.queryAll();
        model.addAttribute("sumpeople",people.size());             //实验室总人数
        List<Sign_in> list = signservice.queryAll();
        int attendance = 0;
        int absence = 0;
        int sick = 0;
        for (int i=0;i<list.size();i++){
            Sign_in day = list.get(i);
            time time = new time();
            String a = day.getSign_time();
            String[]  o = a.split("\\.");
            String[] ti = time.getTime().split("\\.");
            int w = Integer.parseInt(o[2]);
            int w1 = Integer.parseInt(o[1]);
            int x = Integer.parseInt(ti[1]);
            int r = Integer.parseInt(ti[2]);
            if (w1 == x && w == r) {
                if (day.getSick().equals("1")) {
                    sick = sick + 1;
                }
                if (day.getAttendance().equals("1")) {
                    attendance = attendance + 1;
                }
                if (day.getAbsence().equals("1")) {
                    absence = absence + 1;
                }
            }
        }
        model.addAttribute("attendance",attendance);
        model.addAttribute("sick",sick);
        model.addAttribute("absence",absence);
        String notice = noticeservice.find_notice();
        model.addAttribute("notice",notice);
        return "adindex";
    }
    @RequestMapping(value = "/adtables",method = RequestMethod.GET)                                                     //实验室成员信息
    public String adtables(Model model,HttpSession session){
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        List<Information> list = informationservice.queryAll();
        model.addAttribute("list",list);         //遍历前端页面
        return"adtables";
    }
    @RequestMapping(value = "/adcalendar",method = RequestMethod.GET)                                                   //成员出勤管理
    public String calendar(HttpSession session,Model model){
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        List<Sign_in> list1=new ArrayList<>();
        List<Sign_in> list = signservice.queryAll();
        for (int i = 0; i<list.size();i++){
            Sign_in sign_in = list.get(i);
            String t = sign_in.getSign_time();
            String[] temp = t.split("\\.");
            String[] temp1 = time.getTime().split("\\.");
            if (temp[2].equals(temp1[2])){
                String time = sign_in.getSign_time();
                String[]  tim = time.split("\\.");
                String  a = tim[3]+":"+tim[4];
                Sign_in sign_in1 = new Sign_in();
                sign_in1.setAbsence(sign_in.getAbsence());
                sign_in1.setAttendance(sign_in.getAttendance());
                sign_in1.setName(sign_in.getName());
                sign_in1.setSick(sign_in.getSick());
                sign_in1.setSign_time(a);
                list1.add(sign_in1);
            }
        }
        model.addAttribute("list1",list1);
        return"adcalendar";
    }
    @RequestMapping(value = "/adchart",method = RequestMethod.GET)                                                      //出勤统计表
    public String adchart(HttpSession session,Model model){
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        return "adchart";
    }
    @RequestMapping(value = "/adtable-list",method = RequestMethod.GET)
    public String tablelist(HttpSession session,Model model){                                                           //修改资料
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        return"adtable-list";
    }
    @RequestMapping(value = "/adtable-list",method = RequestMethod.POST)
    public String post_tablelist(HttpSession session,Model model){
        loginservice.setpermissionbyid("1",(String) session.getAttribute("student_id"));
        model.addAttribute("admin","设置权限成功！");
        return "adtable-list";
    }
    @RequestMapping(value = "/adtable-list-img",method = RequestMethod.GET)                                             //注册管理员
    public String tablelistimg(HttpSession session,Model model){
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/

        return"adtable-list-img";
    }
    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String form(HttpSession session,Model model){                                                                //管理
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        return"form";
    }
    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String post_form(HttpSession session,Model model,@RequestParam("notice")String notice){
        noticeservice.update_notice(notice);
        model.addAttribute("succ","发布成功！");
        return "form";
    }
    @RequestMapping(value = "/advideo",method = RequestMethod.GET)
    public String video(HttpSession session,Model model){                                                               //空白页
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        return"ad404";
    }
    @RequestMapping(value = "/video_management",method = RequestMethod.GET)
    public String monitoring(HttpSession session,Model model){                                                          //空白页
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        return"ad4041";
    }
    @RequestMapping(value = "/picture_management",method = RequestMethod.GET)
    public String monitoring1(HttpSession session,Model model){                                                          //空白页
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        return"ad4042";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String get_delete(HttpSession session,Model model){
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        return"addelete";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String post_delete(HttpSession session,Model model,@RequestParam("student_id")String student_id){
        if ("".equals(student_id) || student_id == null){
            return "redirect:/adtables";
        }
        try{
            Login login = loginservice.findloginuser(student_id);
            informationservice.deleteBystudent_id(student_id);
            signservice.deleteByname(login.getName());                          //删除所有用户信息
            loginservice.deleteBystudent_id(student_id);
            model.addAttribute("delete","删除成功！");
            return"redirect:/adtables";
        }catch (Exception e){
            System.out.println("空指针！！！！！！！！1");
            return "redirect:/delete";
        }
    }
}
