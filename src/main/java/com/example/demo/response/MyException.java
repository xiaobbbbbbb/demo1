package com.example.demo.response;

public class MyException extends RuntimeException {

        public MyException(Integer code, String msg) {
            super(msg);
            this.code = code;
        }

        private Integer code;
        private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
