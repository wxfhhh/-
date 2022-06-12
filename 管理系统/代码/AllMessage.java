package com.example.demo1.pojo.project1;

import java.sql.*;
import java.util.Scanner;

public class AllMessage {
    //显示全部详情
    public static void stu() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UtilityBill", "root", "8484229");
        //4.定义sql语句
        String sql = "select * from stu  ";
        //5.获取执行sql的对象 Statement
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            String sid1 = rs.getString(1);
            String name1 = rs.getString(2);
            String sex = rs.getString(3);
            String cclass = rs.getString(4);
            double ele = rs.getDouble(5);
            double water = rs.getDouble(6);
            System.out.println("sid:"+sid1+" "+ "name:"+name1+" "+
                    "sex:"+sex+" "+"class:"+cclass+" "+"electric:"+
                    ele+" "+"water:"+water);

        }
        preparedStatement.close();
        rs.close();
    }
    public static void teacher() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UtilityBill", "root", "8484229");
        //4.定义sql语句
        String sql = "select * from teacher ";
//        select * from user where username = ? and password = ?
        //5.获取执行sql的对象 Statement
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
//Before start of result set
        ResultSet rs = preparedStatement.executeQuery();
//        while (!(rs.next())) {
//            System.out.println("数据不存在!");
//           teacher();
//        }
        while (rs.next()) {
            String tid1 = rs.getString(1);
            String name1 = rs.getString(2);
            String sex = rs.getString(3);
            String department = rs.getString(4);
            double ele = rs.getDouble(5);
            double water = rs.getDouble(6);
            System.out.println("tid:" + tid1 + " " + "name:" + name1 + " " +
                    "sex:" + sex + " " + "department:" + department + " " + "electric:" +
                    ele + " " + "water:" + water);

        }
        preparedStatement.close();
        rs.close();
    }
}
