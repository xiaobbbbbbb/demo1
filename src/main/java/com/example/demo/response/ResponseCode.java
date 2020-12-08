package com.example.demo.response;

public enum ResponseCode {
    SUCCESS(0,"OK"),//这里的代码相当于：public static  final ResponseCode SUCCESS = new ResponseCode(0,“ok”)调用类有参构造传值
    SYSTEM_ERROR(5001,"服务器系统异常，请稍后..."),
    PARAMETER_ERROR(5002,"参数异常");

    // 定义的枚举常量属性。
    private int code;// 状态码
    private String message;// 描述

    /**
     * 私有构造,防止被外部调用
     */
    private ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    /**
     * 定义方法,返回描述,跟常规类的定义get没区别
     * @return
     */
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
