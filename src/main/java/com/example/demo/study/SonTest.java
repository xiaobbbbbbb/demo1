package com.example.demo.study;

/**
 * ByteCodeTest
 *
 * @author: niko
 * @date: 2021/5/24 15:00
 */
class Father {
    int x = 10;
    Father(){
      this.printx();
      x=20;
    }

    public void printx(){
      System.out.println("father.x="+x);
    }
}

class Son extends Father{
  int x =30;
  Son(){
    this.printx();
    x=40;
  }
  @Override
  public void printx(){
    System.out.println("son.x="+x);
  }
}

public class SonTest {

  public static void main(String[] args) {
    Father f = new Son();
    System.out.println(f.x);
  }
}

