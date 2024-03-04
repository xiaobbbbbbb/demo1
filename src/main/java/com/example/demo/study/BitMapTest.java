package com.example.demo.study;

import cn.hutool.bloomfilter.bitMap.BitMap;
import cn.hutool.bloomfilter.bitMap.IntMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.elasticsearch.common.recycler.Recycler.C;

/**
 * BitMapTest
 *
 * @author: niko
 * @date: 2021/12/24 14:56
 */
public class BitMapTest {

    public static int clientTotal =5000;
    public static int threadTotal=200;
    public static volatile int count =0;
    private static final Lock lock = new ReentrantLock();
    synchronized private static void  add(){
//        lock.lock();
        try{
         count++;
            System.out.println("count:"+count);
        }finally {
//            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        IntMap bitMap = new IntMap();
//        bitMap.add(5);
//        bitMap.add(5);
//        bitMap.add(7);
//        bitMap.add(222);
//        bitMap.add(145);
//        bitMap.add(678);
//        bitMap.add(777);
//        System.out.println(bitMap.contains(5));

        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,20,10, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
//        ExecutorService executors = Executors.newCachedThreadPool();
//        final Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(200);
        for(int i =0 ;i<threadTotal;i++){
            executor.execute(()->{
                try{
                    add();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
//            executor.shutdown();
        }
        executor.shutdown();
        countDownLatch.await();
        System.out.println("最后执行主线程");
//        ExecutorCompletionService<String> executorService = new ExecutorCompletionService<>(executor);
//
//        Future<String> future1 = executorService.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
////                Thread.sleep(3000);
//                System.out.println("该任务耗时3秒完成...");
//                return "该任务耗时3秒完成";
//            }
//        });
//        Future<String> future2 = executorService.submit(() -> {
////            Thread.sleep(7000);
//            System.out.println("该任务耗时7秒完成...");
//            return "该任务耗时7秒完成";
//        });
//
//        try {
//            for (int i = 0; i < 2; i++) {
//                //会先获取执行结束的线程
//                System.out.println(executorService.take().get());
//            }
//
//            if(future1.isDone() && future2.isDone()){
////                executor.shutdown();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//
//
//        Runnable runnable = () -> {
//
//        System.out.println("run a run !");
//        System.out.println(String.format("%02d", 3));
//        System.out.println(String.format("%02d", 123));
//        };
//        executor.execute(runnable);
//        executor.shutdown();



    }

}
