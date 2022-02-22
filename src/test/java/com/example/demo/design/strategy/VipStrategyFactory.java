package com.example.demo.design.strategy;


import java.util.HashMap;
import java.util.Map;

public class VipStrategyFactory {
    private static VipStrategyFactory factory= new VipStrategyFactory();
    private VipStrategy vipStrategy;
    private static Map<String,Object> strategyMap = new HashMap<>();

    private VipStrategyFactory(){//私有的构造方法 不能直接new对象

    }
    //VIP1 VIP2 VIP3 可用枚举来维护
    static {
        strategyMap.put("VIP1",new Vip1Strategy());
        strategyMap.put("VIP2",new Vip2Strategy());
        strategyMap.put("VIP3",new Vip3Strategy());
    }

    public static VipStrategyFactory getInstance(){
        return factory;
    }

    public VipStrategy getVipStrategy(String vip){
        return  (VipStrategy)strategyMap.get(vip);
    }
}
