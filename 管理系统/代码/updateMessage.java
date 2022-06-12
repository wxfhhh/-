package com.example.demo1.pojo.project1;

import java.sql.*;
import java.util.Scanner;

public class updateMessage {
    //信息修改
    //先删除再添加
    public static void stu() throws Exception {
        System.out.println("这是修改功能窗口");
        System.out.println("请先输入修改的原数据");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UtilityBill", "root", "8484229");
        //4.定义sql语句
        String sql = "delete  from stu where sid=? and name=?";
        String sql2="select sid from stu";
//        select * from user where username = ? and password = ?
        //5.获取执行sql的对象 Statement
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        System.out.println("可根据姓名、学号（教工号）信息删除");
        System.out.println("姓名:");
        Scanner s11=new Scanner(System.in);
        String name = s11.nextLine();
        System.out.println("学号:");
        Scanner s22=new Scanner(System.in);
        String sid = s22.nextLine();

        preparedStatement.setString(1,sid);
        preparedStatement.setString(2,name);
        int rs = preparedStatement.executeUpdate();
        if(rs>0){
            System.out.println("删除成功");
        }else{
            System.out.println("数据不存在");
        }

        System.out.println("对所选择的数据进行修改");
        System.out.println("请输入编号(注意学生编号为12位,老师的编号为6位)");
        Scanner a = new Scanner(System.in);
        String s1 = a.nextLine();
        preparedStatement = conn.prepareStatement(sql2);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            String sid1 = resultSet.getString("sid");
            while(isJudgment.isSame(sid1,s1)){
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
//        for (int i = 0; i < s2.length(); i++) {
//            int length = String.valueOf(s2.charAt(i)).getBytes("UTF-8").length;
//            if (length <= 1) {
//                System.out.println("输入的姓名不是全中文!!!");
//                return;
//            }
//        }
//        Scanner g = new Scanner(System.in);
//        s2 = g.next();
        System.out.println("请输入性别");
        Scanner c = new Scanner(System.in);
        String s3 = c.nextLine();
        while (!(s3.equals("女") || s3.equals("男"))) {
            System.out.println("只能输入 男 或 女");
            Scanner j = new Scanner(System.in);
            s3 = j.nextLine();
        }

        System.out.println("请输入班级(格式为 某某学院-某某班)");
        Scanner d = new Scanner(System.in);
        String s4 = d.next();
        while (!(s4.indexOf("-") == s4.indexOf("院") + 1)) {
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

        //4.定义sql语句
        String sql1 = "insert into stu values(?,?,?,?,?,?)";
//
        //5.获取执行sql的对象 Statement
        preparedStatement=conn.prepareStatement(sql1);
//        preparedStatement.setString(1, w);
        preparedStatement.setString(1, s1);
        preparedStatement.setString(2, s2);
        preparedStatement.setString(3, s3);
        preparedStatement.setString(4, s4);
        preparedStatement.setDouble(5, s5);
        preparedStatement.setDouble(6, s6);
        int rs1 = preparedStatement.executeUpdate();
        if(rs1>0){
            System.out.println("修改成功!");
        }
    }
    public static void teacher() throws Exception {
        System.out.println("这是修改功能窗口");
        System.out.println("请先输入要删除的数据");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UtilityBill", "root", "8484229");
        //4.定义sql语句
        String sql = "delete  from teacher where tid=? and name=?";
//        select * from user where username = ? and password = ?
        //5.获取执行sql的对象 Statement
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        System.out.println("可根据姓名、学号（教工号）信息删除");
        System.out.println("姓名:");
        Scanner t11=new Scanner(System.in);
        String name = t11.nextLine();
        System.out.println("教工号:");
        Scanner t22=new Scanner(System.in);
        String sid = t22.nextLine();

        preparedStatement.setString(1,sid);
        preparedStatement.setString(2,name);
        int rs = preparedStatement.executeUpdate();
        if(rs>0){
            System.out.println("删除成功");
        }else{
            System.out.println("数据不存在");
        }

        //4.定义sql语句
        String sql1 = "insert into teacher values(?,?,?,?,?,?)";
        String sql2="select tid from teacher";
        //5.获取执行sql的对象 Statement
         preparedStatement = conn.prepareStatement(sql1);
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("这是修改功能窗口");
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
            System.out.println("姓名必须都为中文");
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

        preparedStatement=conn.prepareStatement(sql1);
//        preparedStatement.setString(1, w);
        preparedStatement.setString(1, t1);
        preparedStatement.setString(2, t2);
        preparedStatement.setString(3, t3);
        preparedStatement.setString(4, t4);
        preparedStatement.setDouble(5, t5);
        preparedStatement.setDouble(6, t6);

        int rs1 = preparedStatement.executeUpdate();
        if(rs1>0){
            System.out.println("修改成功!");
        }
    }

}
