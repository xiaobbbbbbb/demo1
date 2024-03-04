package com.example.demo.study;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * StringTest
 *
 * @author: niko
 * @date: 2021/5/7 15:51
 */
public class StringTest {

  public static void main(String[] args) {

    String reg ="[1][3|5|6|7|8|9][0-9]{9}";
    String reg2 ="[1-9]abc[1-9]";
    String s = "17455456789";

    System.out.println( s.matches(reg));
    System.out.println( s.matches(reg2));
    Pattern pattern = Pattern.compile(reg);
    Matcher matcher = pattern.matcher("asdfsadf");
    if(matcher.find()){

    }

//    StringBuilder sb = new StringBuilder(100000);
//    Long start = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
//    for(int i=0;i<100000;i++){
//      sb.append("xz");
//    }
//    Long end = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
//    System.out.println("花费:"+(end-start)+"ms");
//    method1();
  }

  public static void method1(){

    String s1 =new String("1"); //s1 返回是堆中地址的引用
    s1.intern();//字符串常量池中存在“1”，此方法返回的是常量池地址
    String s2 ="1";//s2 返回是常量池中的引用地址
    System.out.println(s1==s2);//false
    System.out.println( s1.intern()==s2);//true
    String s3 =new String("1")+new String("1");
    s3.intern();//此时字符串常量池没有"11",调用此方法会重新赋值s3
    String s4 ="11";
    System.out.println(s3==s4);

  }
}

