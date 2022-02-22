package com.example.demo.design.proxy;


public class XiMenQing {

    public static void main(String[] args) {
        Wangpo wangPo;
        //把王婆叫出来
        wangPo = new Wangpo();
        //然后西门庆说，我要和潘金莲Happy,然后王婆就安排了西门庆丢筷子哪出戏：
        wangPo.makeEyesWithMan();
        //看到没有表面是王婆在做，其实爽的是潘金莲
        wangPo.happyWithMan();

        //西门庆勾引贾氏
        JiaShi jiaShi = new JiaShi();
        wangPo = new Wangpo(jiaShi);
        wangPo.makeEyesWithMan();
        wangPo.happyWithMan();

        //通过动态代理来实现

        //目标对象
        KindWomen panJinLian = new PanJinLian();
        System.out.println(panJinLian.getClass());
        // 给目标对象，创建代理对象
        KindWomen proxy =(KindWomen) new ProxyFactory(panJinLian).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.happyWithMan();
    }
}
