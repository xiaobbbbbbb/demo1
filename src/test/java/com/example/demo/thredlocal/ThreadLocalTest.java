package com.example.demo.thredlocal;

import java.util.concurrent.CountDownLatch;

/**
 * ThreadLocalTest
 *
 * @author: niko
 * @date: 2022/9/8 17:16
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public String getStr(){
        return threadLocal.get();
    }

    public void setStr(String str){
        threadLocal.set(str);
    }

    public static void main(String[] args) {
        int threads =9;
        ThreadLocalTest test = new ThreadLocalTest();
//        CountDownLatch countDownLatch = new CountDownLatch(threads);

        for(int i =0;i<threads;i++){
            Thread thread = new LocalThread(test);
            thread.start();
            test.threadLocal.remove();
//            countDownLatch.countDown();
        }
    }

}
