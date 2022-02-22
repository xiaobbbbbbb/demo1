package com.example.demo.design.strategy;

/**
 * 具体Vip1策略 实现类
 */
public class Vip2Strategy implements VipStrategy {
    @Override
    public double getCost(double price) {
        System.out.println("我是vip1，享受会员价9折优惠"+price*0.9);
        return price*0.9;
    }
}
