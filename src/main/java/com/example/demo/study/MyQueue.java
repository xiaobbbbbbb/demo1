package com.example.demo.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MyQueue
 * 实现队列
 * 使用数组实现
 * @author: niko
 * @date: 2021/8/18 10:00
 */
public class MyQueue {
    //队尾的标志
    private int end=0;
    private Integer[] a=new Integer[5];

    //入队
    public void add(int m){
        a[end]=m;
        end++;
    }

    //出队
    public Integer out(){
        if(a[0]==null){
            System.out.println("队列为空，请先向队列中添加数据");
            return null;
        }else {
            Integer re = a[0];
            a[0]=null;
            //将元素前移一位
            for (int i = 0; i < end; i++) {
                if (a[i + 1] != null) {
                    a[i] = a[i + 1];
                } else {
                    a[i] = null;
                    break;
                }
            }
            return re;
        }
    }

    public static void main(String[] args) {
        MyQueue queue =new MyQueue();
        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(7);

        System.out.println( queue.out());
        System.out.println( queue.out());
        System.out.println( queue.out());
        System.out.println( queue.out());
        System.out.println( queue.out());
//        Arrays.copyOf(queue,10);
    }
}

//用集合实现
class ListQueue<T>{
    private int size=0;
    private List<T> list =new ArrayList<>(100);

    //入队
    public void add(T t){
        list.add(t);
        size++;
    }

    //出队
    public T out(){
        if(!list.isEmpty()){
            size--;
            return list.remove(0);
        }
        return null;
    }

}