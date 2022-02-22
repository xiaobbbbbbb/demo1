package com.example.demo.design.builder;

/**
 * 苹果电脑构建者 实现ComputerBuilder
 */
public class MacComputerBuilder implements ComputerBuilder {
    private Computer2 computer2;

    public MacComputerBuilder(String cpu,String ram){
        computer2=new Computer2(cpu,ram);
    }

    @Override
    public Computer2 getComputer() {
        return computer2;
    }

    @Override
    public void setKeyboard() {
        getComputer().setKeyboard("苹果专用键盘");
    }

    @Override
    public void setMainboard() {
        getComputer().setMainboard("苹果A6主板");
    }

    @Override
    public void setUsbCount() {
        getComputer().setUsbCount(8);//8个usb接口
    }
}
