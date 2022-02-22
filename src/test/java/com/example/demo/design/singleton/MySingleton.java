package com.example.demo.design.singleton;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * 设计模式-单例模式
 */
@SpringBootTest
public class MySingleton {

    // 懒汉式，需要的时候才创建
    private static MySingleton singleton = null;

    private MySingleton(){

    }

    public static  MySingleton getInstance(){
          if(singleton == null){
              synchronized(MySingleton.class) {
                  if(singleton == null) {
                      singleton = new MySingleton();
                  }
              }
        }
        return singleton;
    }

    // 饿汉式 类初始化的时候就创建了 线程安全 缺点是会造成资源浪费
//    private static MySingleton singleton = new MySingleton();
//
//    private MySingleton(){
//
//    }
//
//    public static  MySingleton getInstance(){
//        return singleton;
//    }

}
