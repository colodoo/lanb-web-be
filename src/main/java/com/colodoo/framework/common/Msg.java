package com.colodoo.framework.common;

/**
 * @author colodoo
 * @date 2018/10/17 15:25
 * @description
 */
public class Msg {
    //是否成功
    private boolean success;
    //返回数据
    private Object data;
    //提示信息
    private String msg;

    public Msg() {
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Msg(boolean success, Object data, String msg) {
        this.success = success;
        this.data = data;
        this.msg = msg;
    }
}
