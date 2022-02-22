package com.example.demo.design.strategy;

/**
 * 传统的if。。。else模式
 */
public class Client {
    public static void main(String[] args) {
        //传统的 if...else写法
        final String  VIP="VIP1";
        double price = 100;
        if(VIP.equals("VIP1")){
            System.out.println("vip1的会员价打9折。。。"+price*0.9);
        }else if(VIP.equals("VIP2")){
            System.out.println("vip1的会员价打8折。。。"+price*0.8);
        }else if(VIP.equals("VIP3")){
           System.out.println("vip1的会员价打7折。。。"+price*0.7);
        }
        else if(VIP.equals("VIP4")){
           System.out.println("vip1的会员价打6折。。。"+price*0.7);
        }

        //使用策略模式之后
        VipContext context = new VipContext();
        context.getVipPrice(VIP,100);
    }
}
