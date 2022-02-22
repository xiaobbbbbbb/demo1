package com.example.demo;


import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * MathsTest
 *
 * @author: niko
 * @date: 2021/5/31 9:44
 */

@SpringBootTest
public class MathsTest   {


  public void iAdd(){
    int i =-1;
    int j =2;
    int k=127;
    int a=128;

  }

  public void method2(){
    int i =10 ;
//    ++i;
    i++;
  }

  @Test
  public void method3(){
    int i =10 ;
//    ++i;
//    i++;
    i=i++;
    System.out.println(i);
  }

  //创建对象指令
  public void method4()  {
    String s = new String("xxx");
    Object obj = new Object();
    int[] intArray = new int[10];
    try{
      throw  new IOException("xx");

    }catch (IOException E){
      System.out.println("异常");
    }finally {
      System.out.println("finally");

    }
  }

  public static String  tryCatch(){
    String str ="fresh fans";
    try {
      return str;
    }finally {
      str = "xf";
    }
  }

  private int i =1;
  public  void run(int thread){
//    synchronized (new Object()) {
    for(int k =0 ;k<100;k++) {
      i++;
      System.out.println("thread="+thread+",i=" + i);
    }
//    }

  }

  public static void main(String[] args) {
    boolean b =true;
    int i =0;
    System.out.println();
  }

}

