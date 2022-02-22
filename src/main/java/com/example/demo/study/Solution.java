package com.example.demo.study;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Solution
 *
 * @author: niko
 * @date: 2021/8/10 11:54
 */
public class Solution {

  public static void main(String[] args) {
    //测试链表
//    LinkListDemo<Integer> linkListDemo = new LinkListDemo<>();
//    linkListDemo.addNode(2);
//    linkListDemo.addNode(6);
//    linkListDemo.addNode(8);
//    linkListDemo.addNode(0);
//    linkListDemo.addNode(10);
//    linkListDemo.printListFromHead();
//    linkListDemo.addNodeByIndex(2,3);
//    linkListDemo.printListFromHead();
//    linkListDemo.printListFromLast();
    System.out.println(130652+47449+109387+74867+304585);
  }

  /**
   * 实现字符串的反转
   */
  public static String  solve(String str){
    char[] array = str.toCharArray();
    char[] array2 = new char[array.length];
    for(int i=0;i<array.length;i++){
      array2[i] =array[array.length-1-i];
      System.out.println(array2[i]);
    }
    return String.valueOf(array2);
  }

  public static void  dosmthing(){

  }

}

/**
 * 单向链表
 */
class LinkListDemo<T>{

  private class Node {

    private T t;
    private Node next;

    Node() {
      t = null;
    }

    Node(T t){
      this.t=t;
    }

  }
  //头结点
  private Node head;
  //临时结点
  private Node temp;

  public LinkListDemo(){
    this.head = new Node();
  }

  /**     一下是对链表的操作       */

  /**
   * 增加数据 添加到最后
   */
  public void addNode(T t){
    Node newNode = new Node(t);
    temp=head;
    while (temp.next!=null){
      temp=temp.next;
    }
    temp.next=newNode;
  }

  /**
   * 返回链表的长度
   * @return
   */
  public int getLength(){
    temp=head;
    int length=0;
    while(temp.next!=null){
      length++;
      temp=temp.next;
    }
    return length;
  }

  /**
   * 添加元素到指定的位置
   * @param t
   * @param index
   */
  public void addNodeByIndex(T t,int index){
    if(index <1 ||index>getLength()+1){
      System.out.println("插入的位置不合法");
      return;
    }

    int count = 1; //记录遍历的位置
    Node node = new Node(t);
    temp = head;
    while (temp.next != null) {
      if (index == count++) {
        node.next = temp.next;
        temp.next = node;
        return;
      }
      temp = temp.next;
    }

  }

  /**
   * 删除指定位置的元素
   * @param index
   */
  public void deleteByIndex(int index){
    if(index <1 ||index>getLength()+1){
      System.out.println("插入的位置不合法");
      return;
    }
    temp =head;
    int count=0;
    while(temp.next!=null){
      if(index==count++){
        temp.next = temp.next.next;
        return;
      }
      temp =temp.next;
    }

  }

  /**
   * 从头到尾打印所有元素
   */
  public void printListFromHead(){
    temp=head;
    while (temp.next!=null){
      System.out.println("{"+temp.next.t+"}");
      temp=temp.next;
    }
  }

  /**
   *从尾到头打印链表数据
   * 利用栈的后进先出处理
   */
  public void printListFromLast(){
    temp=head;
    Stack<T> stack = new Stack<>();
    while (temp.next!=null){
      stack.push(temp.next.t);
      temp=temp.next;
    }
    while (!stack.isEmpty()){
      System.out.println(stack.pop());
    }
  }
}