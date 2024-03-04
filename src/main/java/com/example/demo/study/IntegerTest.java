package com.example.demo.study;

import com.google.common.util.concurrent.RateLimiter;

/**
 * IntegerTest
 *
 * @author: niko
 * @date: 2021/5/21 17:12
 */
public class IntegerTest {

  private Integer num =1;
  public void add(){
    String s = "xxx";
    System.out.println(s);
  }

  public static void main(String[] args) {
    Thread thread =new Thread();
    int a =0;
    int b = a+++1;
    System.out.println("a="+a);
    System.out.println("b="+b);

    int c =++a+1;
    System.out.println("c="+c);

  }
}

