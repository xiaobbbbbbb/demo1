package com.example.demo.design.proxy;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 设计模式-静态代理模式 要求代理类和被代理类必须实现接口
 *
 * 静态代理总结:
 * 1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 2.缺点:
 *
 * 因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 */
public class Wangpo implements KindWomen {

    private KindWomen kindWomen;

    public Wangpo(){
        this.kindWomen  = new PanJinLian();
    }

    //她可以是KindWomam的任何一个女人的代理，只要你是这一类型
    public Wangpo(KindWomen kindWoman){
        this.kindWomen = kindWoman;
    }

    @Override
    public void makeEyesWithMan() {
        //还可以做一些增加的处理
        System.out.println("抛媚眼之前。。。");
        this.kindWomen.makeEyesWithMan();
        System.out.println("抛媚眼之后。。。");

    }

    @Override
    public void happyWithMan() {
        this.kindWomen.happyWithMan();
    }
}
