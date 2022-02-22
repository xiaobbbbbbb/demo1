package com.example.demo.study;

import java.util.ArrayList;

/**
 * GCuseTest
 *
 * @author: niko
 * @date: 2021/5/13 17:44
 */
public class GCuseTest {



  public static void main(String[] args) {
      ArrayList<byte[]> list = new ArrayList<>();
      for(int i=0;i<18;i++) {
        byte[] arr = new byte[1024 * 1024];//1Mb
        list.add(arr);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
      }
  }
}
