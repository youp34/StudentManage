package com.student.manage.socket;
import com.student.manage.pojo.Information;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connect_mysql {
    private static final String URL="jdbc:mysql://localhost:3306/manage_db?serverTimezone=UTC";
     private static final String NAME="root";
    private static final String PASSWORD="200917";

    public static void main(String[] args) throws Exception{

        Information  information = new Information();
                 //1.加载驱动程序
         Class.forName("com.mysql.cj.jdbc.Driver");
                //2.获得数据库的连接
         Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
                 //3.通过数据库的连接操作数据库，实现增删改查
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("select * from tb_information where finger_id='00f'");//选择import java.sql.ResultSet;
             //如果对象中有数据，就会循环打印出来
        System.out.println(rs.getBytes("name"));
    }
}
