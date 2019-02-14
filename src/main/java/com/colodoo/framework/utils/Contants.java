package com.colodoo.framework.utils;

/**
 * @author colodoo
 * @date 2018/08/14 21:47
 * @description 用于保存所有常量的类
 */
public class Contants {

    /*实用变量*/
    public static final Byte TRUE = Byte.valueOf("1");
    public static final Byte FALSE = Byte.valueOf("0");

    /*返回值相关*/
    public static final int CODE_FAILED = -1;
    public static final int CODE_ZERO = 0;

    /*登录参数相关*/
    //最大登录次数
    public static final int MAX_LOGIN_TRY_COUNT = 5;

    /*表格相关*/
    //列表字段
    public static final String TABLE_ROWS = "rows";
    //总数字段
    public static final String TABLE_TOTAL = "total";

    /*接口提示相关*/
    //保存失败
    public static final String MSG_SAVE_FAIL = "保存失败";
    //删除失败
    public static final String MSG_DELETE_FAIL = "删除失败";
    //更新失败
    public static final String MSG_UPDATE_FAIL = "更新失败";

    /*登录相关*/
    //登录成功
    public static final String LOGIN_SUCCESS = "登录成功!";
    //登录失败
    public static final String LOGIN_FAIL = "您尚未登陆或登录失败!";
    //已经登录
    public static final String LOGINED = "您已经登录!";

    /*注册相关*/
    //注册成功
    public static final String REG_SUCCESS = "注册成功";
    //注册失败
    public static final String REG_FAIL = "注册失败";

    /*会话相关*/
    public static final String SESSION_OBJECT_KEY = "sessionObject";

    /*其他*/


}
