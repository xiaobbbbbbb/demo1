package com.example.demo.reflect;


import com.example.demo.design.singleton.MySingleton;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RelectTest {
    private static final Logger logger= LoggerFactory.getLogger(RelectTest.class);
    private final  static String TAG="com.example.demo.reflect";
    // 创建对象
    public static void reflectNewInstance() {
        try {
            Class<?> classBook = Class.forName("com.example.demo.reflect.Book");
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setName("钢铁是怎样炼成的");
            book.setAuthor("niko");
            logger.info("reflectNewInstance book = " + book.toString());
        } catch (Exception ex) {
            logger.error("xxx",ex);
        }
    }

    // 反射私有的构造方法
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classBook = Class.forName("com.example.demo.reflect.Book");
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class,String.class);
//            Constructor<?> constructor = classBook.getConstructor();
//            Book o =(Book) constructor.newInstance();
//            o.setAuthor("xxx");
//
            declaredConstructorBook.setAccessible(true);
            Object objectBook = declaredConstructorBook.newInstance("Android开发艺术探索","任玉刚");
            Book book = (Book) objectBook;
            logger.info("reflectPrivateConstructor book = " + book.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有属性
    public static void reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("com.example.demo.reflect.Book");
            Object objectBook = classBook.newInstance();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
            logger.info("reflectPrivateField tag = " + tag);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class<?> classBook = Class.forName("com.example.demo.reflect.Book");
            Method methodBook = classBook.getDeclaredMethod("declaredMethod",int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.newInstance();
            String string = (String) methodBook.invoke(objectBook,3);

            logger.info("reflectPrivateMethod string = " + string);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] s ) {
        try {
            // 创建对象
            RelectTest.reflectNewInstance();

            // 反射私有的构造方法
            RelectTest.reflectPrivateConstructor();

            // 反射私有属性
            RelectTest.reflectPrivateField();

            // 反射私有方法
            RelectTest.reflectPrivateMethod();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
