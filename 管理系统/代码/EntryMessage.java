package com.example.demo1.pojo.project1;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.Scanner;

/*
①添加功能:程序能够添加不同学生和教工的记录，提供选择界面供用户选择所要添加的类别，
    要求编号（学生用12位数字的学号作为编号，教师用6位数字的教工号作为编号）要唯一，
    如果添加了重复编号的记录时，则提示数据添加重复并取消添加;
 */
public class EntryMessage {
    public static void teacher() throws Exception {
        //2.注册驱动
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UtilityBill", "root", "8484229");
        //4.定义sql语句
        String sql = "insert into teacher values(?,?,?,?,?,?)";
        String sql1="select tid from teacher";
        //5.获取执行sql的对象 Statement
        PreparedStatement preparedStatement = conn.prepareStatement(sql1);
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("这是添加功能窗口");
        System.out.println("请输入编号(注意学生编号为12位,老师的编号为6位)");
        Scanner a = new Scanner(System.in);
        String t1 = a.nextLine();
        while (resultSet.next()){
            String tid = resultSet.getString("tid");
            while (isJudgment.isSame(tid,t1)){
                System.out.println("此编号已存在,请重新输入");
                Scanner g = new Scanner(System.in);
                t1 = g.nextLine();
            }
        }
        while (!(t1.length() == 6&&isJudgment.isNum(t1))) {
            System.out.println("格式错误!");
            Scanner g = new Scanner(System.in);
            t1 = g.nextLine();
        }

        System.out.println("请输入姓名");
        Scanner b = new Scanner(System.in);
        String t2 = b.next();
        while(!(isJudgment.isChinese(t2))){
            System.out.println("姓名必须为中文!");
            Scanner j = new Scanner(System.in);
            t2 = j.nextLine();
        }
//        int j = 0;
//        for (int i = 0; i < t2.length(); i++) {
//            if (String.valueOf(t2.charAt(i)).getBytes("UTF-8").length <= 1) {
//                System.out.println("输入的姓名不是全中文!!!");
//                j++;
//                return;
//            }
//        }
//        while (j > 0) {
//            System.out.println("输入的姓名不是全中文!!!");
//            Scanner k= new Scanner(System.in);
//            t2=k.nextLine();
//        }

        System.out.println("请输入性别");
        Scanner c = new Scanner(System.in);
        String t3 = c.next();
        while (!(t3.equals("女") || t3.equals("男"))) {
            System.out.println("只能输入 男 或 女");
            Scanner j = new Scanner(System.in);
            t3 = j.nextLine();
        }

        System.out.println("请输入部门(格式为 某某学院 )");
        Scanner d = new Scanner(System.in);
        String t4 = d.next();
        while(!(t4.indexOf("学院") == t4.length()-2)){
            System.out.println("格式不对 格式为 某某学院");
            Scanner j = new Scanner(System.in);
            t4 = j.nextLine();
        }

        System.out.println("请输入用电量");
        Scanner e = new Scanner(System.in);
        String e1=e.nextLine();
        while(!(isJudgment.isNum(e1))){
            System.out.println("不能为中文");
            Scanner l = new Scanner(System.in);
             e1 = l.nextLine();
        }
        double t5=Double.parseDouble(e1);
        while (t5<0){
            System.out.println("用电量要大于0");
            Scanner l = new Scanner(System.in);
            t5 = l.nextDouble();
        }
        System.out.println("请输入用水量");
        Scanner f = new Scanner(System.in);
        String f1=f.nextLine();
        while(!(isJudgment.isNum(f1))){
            System.out.println("不能为中文");
            Scanner l = new Scanner(System.in);
            f1= l.nextLine();
        }
        double t6=Double.parseDouble(f1);
        while(t6<0){
            System.out.println("用水量要大于0");
            Scanner l = new Scanner(System.in);
            t6= l.nextDouble();
        }
        preparedStatement = conn.prepareStatement(sql);
//        preparedStatement.setString(1, w);
        preparedStatement.setString(1, t1);
        preparedStatement.setString(2, t2);
        preparedStatement.setString(3, t3);
        preparedStatement.setString(4, t4);
        preparedStatement.setDouble(5, t5);
        preparedStatement.setDouble(6, t6);
        int rs = preparedStatement.executeUpdate();
        if(rs>0){
            System.out.println("保存成功!");
        }

    }


    public static void stu() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UtilityBill", "root", "8484229");
        //4.定义sql语句
        String sql = "insert into stu values(?,?,?,?,?,?)";
        String sql1="select sid from stu";
        PreparedStatement preparedStatement = conn.prepareStatement(sql1);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("这是添加功能窗口");
        System.out.println("请输入编号(注意学生编号为12位,老师的编号为6位)");
        Scanner a = new Scanner(System.in);
        String s1 = a.nextLine();
        while(resultSet.next()){
            String sid = resultSet.getString("sid");
            while(isJudgment.isSame(sid,s1)){
                System.out.println("此编号已存在,请重新输入");
                Scanner n = new Scanner(System.in);
                s1 = n.nextLine();
            }
        }
        while (!(s1.length() == 12&&isJudgment.isNum(s1))) {
            System.out.println("输入不合法!");
            Scanner n = new Scanner(System.in);
            s1 = n.nextLine();
        }

        System.out.println("请输入姓名");
        Scanner b = new Scanner(System.in);
        String s2 = b.nextLine();
        while(!(isJudgment.isChinese(s2))){
            Scanner j = new Scanner(System.in);
            s2 = j.nextLine();
        }

        System.out.println("请输入性别");
        Scanner c = new Scanner(System.in);
        String s3 = c.nextLine();
        while (!(s3.equals("女") || s3.equals("男"))) {
            System.out.println("只能输入 男 或 女");
            Scanner j = new Scanner(System.in);
            s3 = j.nextLine();
        }

        System.out.println("请输入班级(格式为 某某专业-某某班)");
        Scanner d = new Scanner(System.in);
        String s4 = d.next();
        while (!(s4.indexOf("-") == s4.indexOf("业") + 1)) {
            System.out.println("格式错误! 格式为 某某学院-某某班");
            Scanner j = new Scanner(System.in);
            s4 = j.nextLine();
        }
        System.out.println("请输入用电量");
        Scanner e = new Scanner(System.in);
        String e1 = d.nextLine();
        while(!(isJudgment.isNum(e1))){
            System.out.println("不能有中文");
            Scanner l = new Scanner(System.in);
            e1 = l.nextLine();
        }
        double s5=Double.parseDouble(e1);
        while(s5<0){
            System.out.println("用电量不能小于0");
            Scanner l = new Scanner(System.in);
            s5 = l.nextDouble();
        }
        System.out.println("请输入用水量");
        Scanner f = new Scanner(System.in);
        String f1 = f.nextLine();
        while(!(isJudgment.isNum(f1))){
            System.out.println("不能有中文");
            Scanner l = new Scanner(System.in);
            f1 = l.nextLine();
        }
        double s6=Double.parseDouble(f1);
        while (s6<0){
            System.out.println("用水量不能小于0");
            Scanner l = new Scanner(System.in);
            s6 = l.nextDouble();
        }

        //3.获取数据库连接对象

        //5.获取执行sql的对象 Statement
        //        preparedStatement.setString(1, w);
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, s1);
        preparedStatement.setString(2, s2);
        preparedStatement.setString(3, s3);
        preparedStatement.setString(4, s4);
        preparedStatement.setDouble(5, s5);
        preparedStatement.setDouble(6, s6);
        int rs = preparedStatement.executeUpdate();
        if(rs>0){
            System.out.println("保存成功!");
        }

    }

}

