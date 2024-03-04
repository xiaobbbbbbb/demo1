package com.example.demo.study.lambda;

/**
 * Student1
 *
 * @author: niko
 * @date: 2022/9/13 11:21
 */
public class Student3 {

    private int age;
    private String name;

    public Student3(int age){
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

    public  int compare(Student3 student ){
        return this.getAge() -student.getAge();
    }

    @Override
    public String toString() {
        return "Student1{" +
            "age=" + age +
            ", name='" + name + '\'' +
            '}';
    }
}
