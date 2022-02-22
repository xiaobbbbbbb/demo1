package com.example.demo.study;

import java.util.Queue;

/**
 * CiLinkedList
 *
 * @author: niko
 * @date: 2021/8/13 10:31
 */
public class CiLinkedList<T> {

    private class Node {

        private T t;
        private Node next;
        private Node pre;

        Node() {
        }

        Node(T t) {
            this.t = t;
            next = null;
            pre = null;
        }
    }

    //头结点
    private Node head;
    //尾结点
    private Node tail;
    private int size = 0;

    public CiLinkedList() {
        this.head = new Node();
        this.tail = new Node();
    }

    /**
     * 查看数据是否为空
     */
    public boolean isEmpty() {
        if (head.next == null) {
            return true;
        }
        return false;
    }

    /**
     * 返回链表的长度
     *
     * @return
     */
    public int getLength() {
        Node temp = head;
        int length = 0;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 根据索引返回当前结点数据
     */
    public Node getNodeByIndex(int index) {
        Node rnode = head;
        int dex = -1;
        while (rnode.next != null) {

            if (index == dex) {
                return rnode;
            }
            dex++;
            rnode = rnode.next;
        }
        if (index == size - 1) {
            return rnode;
        }
        return null;
    }

    /**
     * 往链表尾部插入数据
     */
    public void addNodeToLast(T t) {
        Node node = new Node(t);
        Node temp = head;
        //如果是空链表则插入一个节点 这个链表的pre指向为null
        if (this.isEmpty()) {
            head.next = node;
            head.next.pre = null;
            tail.pre = node;
            size++;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.pre = temp;
            tail.pre = node;
            size++;
        }
    }

    /**
     * 链表的指定位置插入一个节点 速度快 复杂度O(n)
     */
    public void add(T t, int index) {
        if (index < 0 || index > size) {
            System.out.println("添加位置不合法");
            return;
        }
        Node node = new Node(t);
        //所在位置的上一个节点
        Node preNode = getNodeByIndex(index - 1);
        node.next = preNode.next;
        preNode.next.pre = node;
        preNode.next = node;
        node.pre = preNode;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index > size) {
            System.out.println("位置不合法");
            return;
        }
        //当移除的节点是最后一个时
        if (index == size) {
            Node preNode = this.getNodeByIndex(index - 1);
            preNode.next = null;
            this.tail = preNode;
            size--;
        } else {
            Node preNode = this.getNodeByIndex(index - 1);

            preNode.next.next.pre = preNode;
            preNode.next = preNode.next.next;
            preNode.next.next = null;
            preNode.next.pre = null;
            size--;
        }
    }

    /**
     * 链表大小
     */
    int size() {
        return this.size;
    }

    /**
     * 获取节点上的元素
     */
    public T getData(int index) {
        Node node = getNodeByIndex(index);
        return node.t;
    }

    @Override
    public String toString() {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        while (node.next != null) {
            sb.append("{" + node.t + "},");
        }
        sb.append("{" + tail.t + "},");
        return sb.toString();
    }

    public static void main(String[] args) {
        CiLinkedList<String> ciLinkedList = new CiLinkedList<>();
        ciLinkedList.addNodeToLast("aaa");
        ciLinkedList.addNodeToLast("bbb");
        ciLinkedList.add("ccc", 1);
    }

}
