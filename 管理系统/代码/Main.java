package com.example.demo1.control.project1;

import com.example.demo1.pojo.project1.student;
import com.example.demo1.pojo.project1.teacher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("输入1为学生入口,输入2为老师入口,输入9重新开始,输入0退出");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i){
            case 1:

                student s = new student();
                s.main();
                break;
            case 2:
                teacher t = new teacher();
                t.main();
                break;
            case 9:
                Main.main(null);
            case 0:
                System.exit(0);
            default:
                System.out.println("请输入正确的数字!");
        }
    }
}
