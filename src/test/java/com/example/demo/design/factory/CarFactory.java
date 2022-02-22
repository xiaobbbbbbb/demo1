package com.example.demo.design.factory;

/**
 * 简单工厂模式
 */
public class CarFactory {

    public static CarAbler getCar(String name) {
        if(name.equals("aodi")){
            return new AodiCar();
        }
        if(name.equals("aotuo")){
            return new AotuoCar();
        }
        return new AotuoCar();
    }
}

interface CarAbler {
    void run();
}

class AodiCar implements CarAbler{
    @Override
    public void run(){
        System.out.println("我可以跑200码");
    }
}

class AotuoCar implements CarAbler{
    @Override
    public void run(){
        System.out.println("我可以跑100码");
    }
}

class TangCar implements CarAbler{
    @Override
    public void run(){
        System.out.println("我是唐");
    }
}

class SongCar implements CarAbler{
    @Override
    public void run(){
        System.out.println("我是宋");
    }
}

class X3Car implements CarAbler{
    @Override
    public void run(){
        System.out.println("我是x3");
    }
}

class X6Car implements CarAbler{
    @Override
    public void run(){
        System.out.println("我是x6");
    }
}



// 工厂方法

interface MyCarFactory{
    CarAbler makeCar(String name);
}

class BydCardFactory implements MyCarFactory{
    @Override
    public CarAbler makeCar(String name){
        if(name.equals("唐")){
            return new TangCar();
        }
        if(name.equals("宋")){
            return new SongCar();
        }
        return new AotuoCar();
    }
}


class BMWFactory implements MyCarFactory{
    @Override
    public CarAbler makeCar(String name){
        if(name.equals("X3")){
            return new X3Car();
        }
        if(name.equals("X6")){
            return new X6Car();
        }
        return new AotuoCar();
    }
}

class App{
    public static void main(String s[]){
        MyCarFactory bmCarFactory = new BMWFactory();
        CarAbler bmx3= bmCarFactory.makeCar("X3");
        bmx3.run();
        bmCarFactory.makeCar("X6");
        MyCarFactory bydFactory = new BydCardFactory();
        CarAbler byd = bydFactory.makeCar("唐");
        byd.run();

    }
}

//抽象工厂方法 把需要的一族的工厂统一实现抽象工厂 

interface MotoFactory{

   // Engine makeEngin(); //引擎
   // Foot makeFoot(); //车胎
    //Shit makeShit();//车架
}

class LifanMotoFactory implements MotoFactory{


}

class JianglinMotoFactory implements MotoFactory{


}