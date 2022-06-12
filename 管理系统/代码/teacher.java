package com.example.demo1.pojo.project1;

import com.example.demo1.control.project1.Main;

import java.util.Scanner;

public class teacher {

    private String department;
    private String tid;
    private String name;
    private String sex;
    private Double Electric;
    private Double water;

    public teacher() {
    }

    public teacher(String department, String tid, String name, String sex, Double electric, Double water) {
        this.department = department;
        this.tid = tid;
        this.name = name;
        this.sex = sex;
        Electric = electric;
        this.water = water;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "department='" + department + '\'' +
                ", cid='" + tid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", Electric=" + Electric +
                ", water=" + water +
                '}';
    }
    public static void main() throws Exception {
        System.out.println("执行老师入口!");
        System.out.println("输入9重新开始,输入10跳到学生入口,输入0退出");
        System.out.println("1添加功能,2查询功能,3修改功能,4删除功能,5显示详情,6水费电费,7存入文件teacher.txt中,8读取teacher.txt中的文件");
        Scanner a = new Scanner(System.in);
        switch (a.nextInt()) {
            case 1:
//执行添加功能
                EntryMessage.teacher();
                break;
            case 2:
//执行查询功能
                SelectMessage.teacher();
                break;
            case 3:
                //修改信息
updateMessage.teacher();
                break;
            case 4:
//删除信息
                deleteMessage.teacher();
                break;
            case 5:
//显示详情信息
                AllMessage.teacher();
                break;
            case 6:
//电费 水费 存入
                SumMoney.teacher();
                break;
            case 7:
//保存到teacher.txt文件中
                Out_Put.teacher();
                break;
            case 8:
                In_Put.teacher();
            case 0:
                System.exit(0);
                break;
            case 9:
                Main.main(null);
            case 10:
                teacher.main();
            default:
                System.out.println("输入格式错误");
                break;
        }
        main();
    }
}
