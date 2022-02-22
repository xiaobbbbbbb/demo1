package com.example.demo.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理 jdk 代理对象不需要实现接口 ，但是被代理对象一定要实现接口
 */
public class ProxyFactory {

    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务2");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("提交事务2");
                        return returnValue;
                    }
                }
        );
    }

}

 class ProxyFactory2 implements InvocationHandler {

    //维护一个目标对象
    private Object target;
    public ProxyFactory2(Object target){
        this.target=target;
    }

     @Override
     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         // 在转调具体目标对象之前，可以执行一些功能处理
         System.out.println("前置增强处理： yoyoyo...");

         // 转调具体目标对象的方法(三要素：实例对象 + 实例方法 + 实例方法的参数)
         Object obj = method.invoke(target, args);

         // 在转调具体目标对象之后，可以执行一些功能处理
         System.out.println("后置增强处理：hahaha...");

         return obj;
     }

     public static void main(String[] s){
        KindWomen kindWomen = new PanJinLian();//真实的目标对象
         //生产代理对象
         KindWomen proxy = (KindWomen)Proxy.newProxyInstance(kindWomen.getClass().getClassLoader(),kindWomen.getClass().getInterfaces(),new ProxyFactory2(kindWomen));
         proxy.happyWithMan();

     }
 }
