package com.example.demo1.pojo.project1;

import com.example.demo1.control.project1.Main;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Scanner;

public class student {
    private String class1;
    private String cid;
    private String name;
    private String sex;
    private Double Electric;
    private Double water;

    public student() {
    }

    public student(String class1, String cid, String name, String sex, Double electric, Double water) {
        this.class1 = class1;
        this.cid = cid;
        this.name = name;
        this.sex = sex;
        Electric = electric;
        this.water = water;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    @Override
    public String toString() {
        return "student{" +
                "class1='" + class1 + '\'' +
                ", cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", Electric=" + Electric +
                ", water=" + water +
                '}';
    }

    public static void main() throws Exception {
        System.out.println("执行学生入口!");
        System.out.println("输入9重新开始,输入10跳到老师入口,输入0退出");
        System.out.println("1添加功能,2查询功能,3修改功能,4删除功能,5显示详情,6水费电费,7存入文件stu.txt中,8读取stu.txt中的文件");
        Scanner a = new Scanner(System.in);
        switch (a.nextInt()) {
            case 1:
//执行添加功能
                EntryMessage.stu();
                break;
            case 2:
//执行查询功能
                SelectMessage.stu();
                break;
            case 3:
                //修改信息
                updateMessage.stu();
                break;
            case 4:
//删除信息
                deleteMessage.stu();
                break;
            case 5:
//显示详情信息
                AllMessage.stu();
                break;
            case 6:
// 水费 电费 存入
                SumMoney.stu();
                break;
            case 7:
//存入文件stu.txt中
                Out_Put.stu();
                break;
            case 8:
//读取stu.txt文件
                In_Put.stu();
                break;
            case 0:
                System.exit(0);
                break;
            case 9:
                Main.main(null);
                break;
            case 10:
                teacher.main();
            default:
                System.out.println("输入格式错误");
                break;
        }
        main();
    }


}
