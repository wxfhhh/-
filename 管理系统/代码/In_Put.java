package com.example.demo1.pojo.project1;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class In_Put {
public static void stu() throws Exception {
    FileReader fr=new FileReader("C:\\\\txt\\\\stu.txt");
    int len=0;
    char[] chars=new char[1024];
    while ((len= fr.read(chars))!=-1){
        System.out.println(new String(chars,0,len));
    }
    fr.close();

}
    public static void teacher() throws Exception {
        FileReader fr=new FileReader("C:\\\\txt\\\\teacher.txt");
        int len=0;
        char[] chars=new char[1024];
        while ((len= fr.read(chars))!=-1){
            System.out.println(new String(chars,0,len));
        }
        fr.close();

    }
}
