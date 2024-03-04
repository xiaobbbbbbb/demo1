package com.example.demo.study.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * LambdaTest
 * 方法引用
 * @author: niko
 * @date: 2022/9/13 10:55
 */
public class LambdaTest {

    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();

//        test.getAbs(10,(num)->num);
//        //方法引用 类方法方法， 相当于重写了函数接口的方法
//        test.getAbs(-10,MathUtil::abs);
//        //等价于上面的
//        test.getAbs(-20,(num -> {
//            return MathUtil.abs(num);
//        }));
        //第一种 静态方法 （类名::静态方法名）
        List<Student1> student1s = new ArrayList<>();
        Student1 student1 = new Student1(10);
        Student1 student2 = new Student1(50);
        Student1 student3 = new Student1(20);
        student1s.add(student1);
        student1s.add(student2);
        student1s.add(student3);
        student1s.sort(Student1::compare);//方法引用 静态方法 （类名::静态方法名）
        System.out.println(student1s);

        //第二种 对象实例方法（对象名::实例方法名）
        List<Student2> student2s = new ArrayList<>();
        Student2 student21 = new Student2(20);
        Student2 student22 = new Student2(50);
        Student2 student23 = new Student2(10);
        student2s.add(student21);
        student2s.add(student22);
        student2s.add(student23);
        student2s.sort(student22::compare);//方法引用 实例方法（对象名::实例方法名）
        System.out.println(student2s);

        //第三种 类的实例方法（类名::实例方法名）
        List<Student3> student3s = new ArrayList<>();
        Student3 student31 = new Student3(50);
        Student3 student32 = new Student3(20);
        Student3 student33 = new Student3(10);
        student3s.add(student31);
        student3s.add(student32);
        student3s.add(student33);
        student3s.sort(Student3::compare);//方法引用 类实例方法（类名::实例方法名）
        System.out.println(student2s);
    }

    public int getAbs(int num,Stringable stringable){
        System.out.println(stringable.getabs(num));
        return stringable.getabs(num);
    }

}
