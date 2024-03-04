package com.example.demo;


import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
//    LocalDateTime dateTime1 = LocalDateTime.now();
//    LocalDateTime dateTime2 = LocalDateTime.of(2023,6,30,0,0,0);
//    long l = Duration.between(dateTime1, dateTime2).toDays();
//    System.out.println(l);

      Scanner scanner = new Scanner(System.in);
      System.out.print("请输入总人数：");
      int n = scanner.nextInt();
      System.out.print("请输入报数的数字：");
      int m = scanner.nextInt();

      List<Integer> circle = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
        circle.add(i);
      }

      int index = 5;
      while (circle.size() > 1) {
        index = (index + m - 1) % circle.size(); // 计算报数的人的索引
        circle.remove(index); // 将报数的人从圆圈中删除
      }

      System.out.println("最后留下的人是：" + circle.get(0)); // 输出最后留下的人的编号

  }

}

