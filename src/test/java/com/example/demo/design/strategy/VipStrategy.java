package com.example.demo.design.strategy;

/**
 * 策略模式 抽象策略类
 * 策略模式仅仅是封装算法，如何使用算法由客户端决定
 * 策略模式可以充分的体现面向对象设计原则中的封装变化、多用组合，少用继承、针对接口编程，不针对实现编程等原则。
 */
public interface VipStrategy {
    double getCost(double price);//获取会员价格
}
