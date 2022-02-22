package com.example.demo.design.builder;

/**
 * 经典builder模式
 */
public class Computer2 {

    private String cpu;

    private String keyboard;

    private String ram;

    private String mainboard;

    private int usbCount;

    public Computer2(String cpu,String ram){
        this.cpu=cpu;
        this.ram=ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getMainboard() {
        return mainboard;
    }

    public void setMainboard(String mainboard) {
        this.mainboard = mainboard;
    }

    public int getUsbCount() {
        return usbCount;
    }

    public void setUsbCount(int usbCount) {
        this.usbCount = usbCount;
    }

    @Override
    public String toString() {
        return "Computer2{" +
                "cpu='" + cpu + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", ram='" + ram + '\'' +
                ", mainboard='" + mainboard + '\'' +
                ", usbCount=" + usbCount +
                '}';
    }
}
