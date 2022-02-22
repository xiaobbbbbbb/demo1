package com.example.demo.design.builder;

/**
 * 建造者模式 产品部分
 */
public class Product {

    private String partA;
    private String partB;
    private String partC;


    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }
    public void show() {
        //显示产品的特性
        System.out.println("我是一个产品生产好了哦");
    }
}

//抽象建造者
abstract class Builder{

    protected Product product =new Product();

    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    //返回产品对象
    public Product getResult() {
        return product;
    }

}
//具体建造者
 class ConcreteBuilder extends Builder {

    public void buildPartA() {
        super.product.setPartA("建造 PartA");
    }
    public void buildPartB() {
        product.setPartB("建造 PartB");
    }
    public void buildPartC() {
        product.setPartC("建造 PartC");
    }
}
//指挥者 调用建造者中的方法完成复杂对象的创建。
class Director {

    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}

 class Client {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product1 = director.construct();
        product1.show();
        Product product2 = director.construct();
        product2.show();
        System.out.println(product1==product2);

    }
}
