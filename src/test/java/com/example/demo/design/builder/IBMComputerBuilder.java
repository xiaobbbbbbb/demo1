package com.example.demo.design.builder;

public class IBMComputerBuilder implements ComputerBuilder {

    private Computer2 computer2;

    public IBMComputerBuilder(String cpu,String ram){
        computer2=new Computer2(cpu,ram);
    }

    @Override
    public void setUsbCount() {
        computer2.setUsbCount(6);
    }

    @Override
    public void setKeyboard() {
        getComputer().setKeyboard("殷桃");
    }

    @Override
    public void setMainboard() {
        getComputer().setMainboard("魏欣");
    }

    @Override
    public Computer2 getComputer() {
        return computer2;
    }
}
