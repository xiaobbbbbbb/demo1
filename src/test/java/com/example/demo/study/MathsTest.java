package com.example.demo.study;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * MathsTest
 *
 * @author: niko
 * @date: 2021/5/31 9:44
 */

@SpringBootTest
public class MathsTest {

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
    long i =10 ;
//    ++i;
    i++;
    System.out.println(i);
  }

}
