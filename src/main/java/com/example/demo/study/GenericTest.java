package com.example.demo.study;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * GenericTest
 *泛型的使用 since jdk1.5
 * 泛型类 ，泛型接口，泛型方法，泛型返回值，泛型参数
 * @author: niko
 * @date: 2021/7/27 15:57
 */
public class GenericTest {

  public static void main(String[] args) {
    //1.子类继承父类指定了泛型类型则在实例化的时候不需要指明泛型
     Order order = new SupOrder();
     //2.泛型继承
     Order<String> order1 = new SupOrder1<>();
     order1.setOrderT("你好啊！");

    //通配符的问题
    List<? > list =null;
    List<String> list2 =new ArrayList<>(10);
    list2.add("AA");
    list2.add("BB");
    list2.add("CC");
    list=list2;
    //通配符不能添加元素 null除外
//    list.add("DD");
    list.add(null);
    //通配符可以读
    Object o = list.get(0);
    System.out.println(o);

    /**
     *     有限制条件的通配符
     *     ? extends List 必须是List子类
     *     ? super List 必须是List的父类
     */
  }

}



class Order<T>{
  String orderName;
  Integer id;
  T orderT;

  Order(){

  }

  Order(String orderName,Integer id,T orderT){
    this.id = id ;
    this.orderName =orderName;
    this.orderT =orderT;
  }

  public T getOrderT(){
    return this.orderT;
  }

  public void setOrderT(T orderT){
    this.orderT =orderT;
  }
  //泛型方法
  public <E> E getValue(){
    return null;
  }

  //通配符的情况

  public void show(List<?> list){
    Iterator<?> iterator = list.iterator();
    while (iterator.hasNext()){
      Object next = iterator.next();
      System.out.println(next);
    }
  }
}

class SupOrder extends Order<String>{

}
class SupOrder1<T> extends Order<T>{

}