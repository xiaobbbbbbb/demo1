package com.example.demo.study;

/**
 * Josepfu
 * 约瑟夫环
 * 丢手帕问题
 * @author: niko
 * @date: 2021/8/19 14:16
 */
public class Josepfu {

    private BoyNode head;

    public void addNode(int nums){
        //校验nums
        if(nums<1){
            System.out.println("非法的数量！");
            return;
        }
        BoyNode temp =null;
        for(int i=1;i<=nums;i++){
           BoyNode boy = new BoyNode(i);
           if(i==1){
               head =boy;
               head.setNext(head);
               temp =head;
           }else{
               temp.setNext(boy);
               boy.setNext(head);
               temp=boy;
           }
        }
    }

    //输出节点数据
    public void printNode(){
        if(head==null){
            System.out.println("链表为空");
            return;
        }
        BoyNode node =head;
        while(true) {
            System.out.println("输出节点："+node.getNo());
            if(node.getNext()==head){
                break;
            }
            node=node.getNext();
        }

    }

    /**
     * 出圈逻辑
     * @param startNo 起始位置 从第几个人开始数数
     * @param count 间隔人数，没隔几个人出局
     * @param nums 总共有多少人
     */
    public void countBoy(int startNo,int count,int nums){
        //校验数据合法性
        if(startNo>nums||count<1||startNo<1||nums<1){
            System.out.println("非法的参数");
            return;
        }
        addNode(nums);

        //尾节点
        BoyNode tail = head;
        while (tail.getNext()!=head){
            tail = tail.getNext();
        }
        //移动首尾节点到startNo位置
        for(int i=0;i<startNo-1;i++){
            head=head.getNext();
            tail=tail.getNext();
        }
        //出圈逻辑
        while (true){
            if(tail==head){//只有一个人了
                break;
            }
            else{
                //移动出圈
                for(int i=0;i<count-1;i++){
                    head=head.getNext();
                    tail=tail.getNext();
                }
                System.out.println("出去的人："+head.getNo());
                head=head.getNext();
                tail.setNext(head);
            }
        }
        System.out.println("最后留在圈中的人："+head.getNo());
    }

    public static void main(String[] args) {
        Josepfu josepfu =new Josepfu();
//        josepfu.printNode();
//        josepfu.addNode(3);
//        josepfu.printNode();
        josepfu.countBoy(4,6,15);
//        Integer.parseInt()
    }
}

class BoyNode{
    private int no;
    private BoyNode next;
    BoyNode(int no ){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }
}