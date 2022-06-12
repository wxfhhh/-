package com.example.demo1.pojo.project1;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Out_Put {
    //输出保存到文件中
//    public static FileWriter stuEle(student s){
//        FileWriter osw = null;
//
//        {
//            try {
//                osw = new FileWriter("C:\\txt\\stuEle数据.txt",true);
//                osw.write(s.toString());
//                osw.write("\r\n");
//                osw.flush();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return osw;
//    }
    public static void stu(){
        FileWriter osw;

        {
            try {
                osw = new FileWriter("C:\\txt\\stu.txt");
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
                    student s=new student(cclass,sid1,name1,sex,ele,water);
                    osw.write(s.toString());
                    osw.write("\r\n");
                    osw.flush();

                }
                preparedStatement.close();
                rs.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void teacher(){
        FileWriter osw;

        {
            try {
                osw = new FileWriter("C:\\txt\\teacher.txt");
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
                    teacher t=new teacher(department,tid1,name1,sex,ele,water);
                    osw.write(t.toString());
                    osw.write("\r\n");
                    osw.flush();
                }
                preparedStatement.close();
                rs.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//    public static FileWriter teacherEle(teacher t){
//        FileWriter osw = null;
//
//        {
//            try {
//                osw = new FileWriter("C:\\txt\\teacherEle数据.txt",true);
//                osw.write(t.toString());
//                osw.write("\r\n");
//                osw.flush();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return osw;
//    }

}
