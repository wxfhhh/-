package com.example.demo1.pojo.project1;

import java.io.UnsupportedEncodingException;

public class isJudgment {
    public static boolean isChinese(String s){
        int j=0;
        for (int i=0; i<s.length(); i++) {
            try {
                if(String.valueOf(s.charAt(i)).getBytes("UTF-8").length <= 1){
                    j++;
//                    System.out.println("输入的姓名不是全中文!!!");
                    break;
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (j==0){
            //全都为中文
            return true;
        }else{
            return false;
        }
    }
    public static boolean isNum(String s){
        int j=0;
        for (int i = 0; i < s.length(); i++) {
            if((s.charAt(i) < '0' || s.charAt(i) > '9')&& s.charAt(i)!='.'){
                j++;
//                System.out.println("输入编号不是全部数字!!!");
                break;
            }
        }
        if (j==0){
            //全都为数字还有 .
            return true;
        }else{
            //有中文
            return false;
        }
    }
    public  static boolean isSame(String a,String b){
        if (a.equals(b)){
            return true;
        }else
            return false;
    }
}
