package com.example.demo.study;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * StringTest
 *
 * @author: niko
 * @date: 2021/5/7 15:51
 */
public class StringTest {

  public static void main(String[] args) {
//    StringBuilder sb = new StringBuilder(100000);
//    Long start = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
//    for(int i=0;i<100000;i++){
//      sb.append("xz");
//    }
//    Long end = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
//    System.out.println("花费:"+(end-start)+"ms");
    method1();
  }

  public static void method1(){
    String s1 =new String("1");
    s1.intern();//字符串常量池中存在“1”，调用此方法没用
    String s2 ="1";
    System.out.println(s1==s2);//false
    String s3 =new String("1")+new String("1");
    s3.intern();//此时字符串常量池没有"11",调用此方法会重新赋值s3
    String s4 ="11";
    System.out.println(s3==s4);

  }
}
