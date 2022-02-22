package com.example.demo.design.strategy;

/**
 * 上下文角色（Context）：用来操作策略的上下文环境，屏蔽高层模块（客户端）对策略，算法的直接访问，封装可能存在的变化；
 */
public class VipContext {
    private VipStrategy vipStrategy;

    /**
     * 实现会员价
     */
    public double getVipPrice(String vip,double price){
        vipStrategy = VipStrategyFactory.getInstance().getVipStrategy(vip);
        return vipStrategy.getCost(price);
    }

    public VipStrategy getVipStrategy() {
        return vipStrategy;
    }

    public void setVipStrategy(VipStrategy vipStrategy) {
        this.vipStrategy = vipStrategy;
    }
}
