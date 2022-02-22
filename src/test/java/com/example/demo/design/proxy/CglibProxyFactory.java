package com.example.demo.design.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理 不需要代理对象实现接口 ，代理的类不能为final,否则报错 .
 * 目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.
 * spring AOP 方法拦截器
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Object target;//目标对象


    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务...");

        //执行目标对象的方法
        Object returnValue = method.invoke(target, objects);

        System.out.println("提交事务...");

        return returnValue;
    }
}


/**
 * 测试类
 */
 class App {

    public static void main(String[] args) {

        boolean isOk =false;
        assert isOk :"is not safe";

        System.out.println("断言通过!");
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new CglibProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }


}