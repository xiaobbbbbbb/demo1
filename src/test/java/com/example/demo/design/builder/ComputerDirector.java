package com.example.demo.design.builder;

/**
 * ComputerBuilder 调用者
 */
public class ComputerDirector {

    public void makeComputer(ComputerBuilder builder){
        builder.setUsbCount();
        builder.setMainboard();
        builder.setKeyboard();
    }

}

class App2{
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();
        MacComputerBuilder macComputerBuilder = new MacComputerBuilder("苹果","128G");
        director.makeComputer(macComputerBuilder);
        Computer2 maccomputer2 = macComputerBuilder.getComputer();
        System.out.println("mac computer:"+maccomputer2.toString());

        IBMComputerBuilder ibmComputerBuilder = new IBMComputerBuilder("IBM","256G");
        director.makeComputer(ibmComputerBuilder);
        Computer2 ibmcomputer2 = ibmComputerBuilder.getComputer();
        System.out.println("ibm computer:"+ibmcomputer2.toString());

    }

}