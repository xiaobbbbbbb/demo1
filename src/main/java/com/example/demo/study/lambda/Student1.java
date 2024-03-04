package com.example.demo.study.lambda;

/**
 * Student1
 *
 * @author: niko
 * @date: 2022/9/13 11:21
 */
public class Student1 {

    private int age;
    private String name;

    public Student1(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int compare(Student1 student1,Student1 student2 ){
        return student1.getAge() -student2.getAge();
    }

    @Override
    public String toString() {
        return "Student1{" +
            "age=" + age +
            ", name='" + name + '\'' +
            '}';
    }
}
