package com.colodoo.framework.exception;

/**
 * @author colodoo
 * @date 2018/8/10 22:56
 * @description 应用层面的异常
 */
public class AppException extends Exception {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public AppException(String msg) {
        this.msg = msg;
    }
}
