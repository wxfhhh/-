package com.example.demo1.pojo.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteMessage {
    //信息删除
    public static void stu() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UtilityBill", "root", "8484229");
        //4.定义sql语句
        String sql = "delete  from stu where sid=? and name=?";
//        select * from user where username = ? and password = ?
        //5.获取执行sql的对象 Statement
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        System.out.println("可根据姓名、学号（教工号）信息删除");
        System.out.println("姓名:");
        Scanner s1=new Scanner(System.in);
        String name = s1.nextLine();
        System.out.println("学号:");
        Scanner s2=new Scanner(System.in);
        String sid = s2.nextLine();

        preparedStatement.setString(1,sid);
        preparedStatement.setString(2,name);
        int rs = preparedStatement.executeUpdate();
        if(rs>0){
            System.out.println("删除成功");
        }else{
            System.out.println("数据不存在");
        }

    }
    public static void teacher() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UtilityBill", "root", "8484229");
        //4.定义sql语句
        String sql = "delete  from teacher where tid=? and name=?";
//        select * from user where username = ? and password = ?
        //5.获取执行sql的对象 Statement
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        System.out.println("可根据姓名、学号（教工号）信息删除");
        System.out.println("姓名:");
        Scanner t1 = new Scanner(System.in);
        String name = t1.nextLine();
        System.out.println("教工号:");
        Scanner t2 = new Scanner(System.in);
        String tid = t2.nextLine();
        preparedStatement.setString(1,tid);
        preparedStatement.setString(2,name);
        int rs = preparedStatement.executeUpdate();
        if(rs>0){
            System.out.println("删除成功");
        }else{
            System.out.println("数据不存在");
        }
    }
}
