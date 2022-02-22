package com.example.demo.design.builder;

import java.util.ArrayList;

/**
 * 传统Builder 模式的 javabean
 */

public class Computer {

    private final String cpu;//必须
    private final String ram;//必须
    private final int usbCount;//可选
    private final String keyboard;//可选
    private final String display;//可选

    private Computer(Builder builder){
        this.cpu=builder.cpu;
        this.ram=builder.ram;
        this.usbCount=builder.usbCount;
        this.keyboard=builder.keyboard;
        this.display=builder.display;
    }
    public static class Builder{
        private String cpu;//必须
        private String ram;//必须
        private int usbCount;//可选
        private String keyboard;//可选
        private String display;//可选

        public Builder(String cup,String ram){
            this.cpu=cup;
            this.ram=ram;
        }

        public Builder setUsbCount(int usbCount) {
            this.usbCount = usbCount;
            return this;
        }
        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }
        public Builder setDisplay(String display) {
            this.display = display;
            return this;
        }
        public Computer build(){
            return new Computer(this);
        }
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public int getUsbCount() {
        return usbCount;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public String getDisplay() {
        return display;
    }


}

class App{
    private static int count=0;
    public static void recursion(long a,long b,long c) {
        long e = 1, f = 2, g = 3, h = 4, i = 5, k = 6, q = 7, x = 8, y = 9, z = 10;
        count++;
        recursion(a, b, c);

    }
    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("总空间:"+runtime.totalMemory()/(1024*1024));
        System.out.println("剩余空间:"+runtime.freeMemory()/(1024*1024));
        ArrayList<String > list = new ArrayList<>(100);

//        runtime.freeMemory();
//        Computer computer = new Computer.Builder("CMD","三星").setKeyboard("海盗船").setUsbCount(123).build();
        while (true){
            list.add(new String("xxxx"));


//            hello();
        }
//        Thread.sleep(1000000);
    }

}
