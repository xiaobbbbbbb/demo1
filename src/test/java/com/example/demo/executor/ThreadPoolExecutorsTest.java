package com.example.demo.executor;

import io.lettuce.core.RedisClient;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TheardPoolExecutorsTest
 *
 * @author: niko
 * @date: 2023/3/16 15:21
 */
@SpringBootTest
public class ThreadPoolExecutorsTest {
    private static final Logger log = org.apache.log4j.Logger.getLogger(ThreadPoolExecutorsTest.class);
    private static Executor executor1 = Executors.newSingleThreadExecutor();
    private static Executor executor2 = Executors.newCachedThreadPool();
    private static Executor executor = Executors.newFixedThreadPool(20);
    private static Executor executor4 = Executors.newScheduledThreadPool(20);
    private volatile Integer count =0;
//    private static Executor executor = Executors.newFixedThreadPool(5);

    synchronized public void method1(){
        log.info("method1 start");
        try {
            log.info("method1 excute");
            Thread.sleep(1000);
        }catch (Exception e){
            log.error(e);
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.tryLock();
        log.info("method1 end");
    }
    public void method2(){
        log.info("method2 start");
        try {
            log.info("method2 excute");
            Thread.sleep(1000);
        }catch (Exception e){
            log.error(e);
        }
        log.info("method2 end");
    }

    public static void main(String[] args) {
        ThreadPoolExecutorsTest test = new ThreadPoolExecutorsTest();
        new Thread(()->{
            test.method1();
        }).start();
        new Thread(()->{
            test.method2();
        }).start();

    }

    @Test
    public void test() {
//        CountDownLatch countDownLatch = new CountDownLatch();
        for (int i = 0; i < 3; i++){
            executor.execute(() -> {
                    for (int j = 0; j < 100; j++) {

                        log.info(count++);
                    }
                    log.info("这里是线程-->"+Thread.currentThread().getName());
                }
            );
        }
        log.info("结果:"+count);
    }
}
