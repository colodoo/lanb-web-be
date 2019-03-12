package com.colodoo.framework.easyui;

import java.io.Serializable;

/**
 * 分页实体类
 * 
 */
public class Page implements Serializable {

    // 当前页码
    private int page = 1;
    // 每页多少行
    private int rows = 10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
