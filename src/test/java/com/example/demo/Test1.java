package com.example.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.junit.jupiter.api.Test;

/**
 * Test1
 *
 * @author: niko
 * @date: 2021/6/8 11:13
 */
public class Test1 {

  public static void main(String[] args) {
    //类的主动使用 会进行类的初始化clinit()
    Order order = new Order();
  }

  @Test
  public void test2(){
    ObjectOutputStream objectOutputStream = null;
    try {
      objectOutputStream = new ObjectOutputStream(new FileOutputStream("order.data"));
      objectOutputStream.writeObject(new Order());

    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      try {
        if(objectOutputStream!=null)
          objectOutputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }

  @Test
  public void test3(){
    ObjectInputStream objectInputStream =null;
    try {
      objectInputStream = new ObjectInputStream(new FileInputStream("order.data"));

      Order order = (Order) objectInputStream.readObject();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }finally {
      try {
        if(objectInputStream!=null)
          objectInputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  @Test
  public void test4(){
    System.out.println(Son.num);
  }
}

class Order implements Serializable {
  static {
    System.out.println("静态类的初始化");
  }
}

class Son extends Order{
  static {
    System.out.println("子类的初始化");

  }
  public static int num=1;

}