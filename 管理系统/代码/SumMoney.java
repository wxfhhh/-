package com.example.demo1.pojo.project1;

import java.io.FileWriter;
import java.sql.*;

public class SumMoney {
    //计算总量
    /*
能根据多种参数进行统计、归类。、能统计学生和教工的用水用电量,所
要交纳的电费和水费、未交纳水电费的人员信息；
能按照用电量从高到底的顺序对每一条
记录进行排序，并将结果写入副本文本文档中（水费：3.10 元/𝑚3；电费：0.588 元/度）
     */
    public static void stu() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UtilityBill", "root", "8484229");
        //4.定义sql语句
        String sql = "select * from stu ";
         String sql1="select * from stu order by Electric DESC";
//        select * from user where username = ? and password = ?
        //5.获取执行sql的对象 Statement
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        double sumEle;
        double sumWater;
        while (rs.next()) {
            String sid1 = rs.getString(1);
            String name1 = rs.getString(2);
            String sex = rs.getString(3);
            String cclass = rs.getString(4);
            double ele = rs.getDouble(5);
            double water = rs.getDouble(6);
            sumEle = ele * 0.55;
            sumWater = water * 3.10;
            System.out.println("sid:" + sid1 + " " + "name:" + name1 + " " +
                    "sex:" + sex + " " + "class:" + cclass + " " + "electric:" +
                    ele + " " + "water:" + water + " " + "电费:" + sumEle + " " + "水费:" + sumWater);

        }
        preparedStatement = conn.prepareStatement(sql1);
        rs = preparedStatement.executeQuery();
        FileWriter osw = new FileWriter("C:\\txt\\stuEle数据.txt");
        while(rs.next()){
            String sid1 = rs.getString(1);
            String name1 = rs.getString(2);
            String sex = rs.getString(3);
            String cclass = rs.getString(4);
            double ele = rs.getDouble(5);
            double water = rs.getDouble(6);
            student s=new student(cclass,sid1,name1,sex,ele,water);
                osw.write(s.toString());
                osw.write("\r\n");
                osw.flush();
        }
        osw.close();

        System.out.println("已将数据按用电量从高到低排序,并放到stuEle.txt文件中");
        preparedStatement.close();
        rs.close();
    }

    public static void teacher() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UtilityBill", "root", "8484229");
        //4.定义sql语句
        String sql = "select * from teacher ";
        String sql1="select * from teacher order by Electric DESC";
//        select * from user where username = ? and password = ?
        //5.获取执行sql的对象 Statement
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
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

        preparedStatement = conn.prepareStatement(sql1);

        rs = preparedStatement.executeQuery();
        FileWriter osw = new FileWriter("C:\\txt\\teacherEle数据.txt");
        while (rs.next()) {
            String tid1 = rs.getString(1);
            String name1 = rs.getString(2);
            String sex = rs.getString(3);
            String department = rs.getString(4);
            double ele = rs.getDouble(5);
            double water = rs.getDouble(6);
            teacher t=new teacher(department,tid1,name1,sex,ele,water);
                osw.write(t.toString());
                osw.write("\r\n");
                osw.flush();
        }
        osw.close();
        System.out.println("已将数据按用电量从高到低排序,并放到teacherEle.txt文件中");
        preparedStatement.close();
        rs.close();
    }
}



