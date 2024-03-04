package com.example.demo.thredlocal;

/**
 * LocalThread
 *
 * @author: niko
 * @date: 2022/9/8 18:05
 */
public class LocalThread extends Thread{

    private ThreadLocalTest test;

    public ThreadLocalTest getTest() {
        return test;
    }

    public void setTest(ThreadLocalTest test) {
        this.test = test;
    }

    public LocalThread(ThreadLocalTest test){
        this.test =test;
    }

    @Override
    public  void run(){
        test.setStr(Thread.currentThread().getName());
        System.out.println("test.getStr()------->"+test.getStr());
    }
}
