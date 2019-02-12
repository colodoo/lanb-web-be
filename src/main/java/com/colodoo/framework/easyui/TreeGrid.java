package com.colodoo.framework.easyui;

import java.util.List;

/**
 * 树形数据表格（1）
 * 1、这个方法需要遍历，但是不需要处理每个数据
 * 2、使用方法是继承这个实体类
 * 3、如果数据不多的话，可以直接生成相应的List
 * 4、如果数据过多的情况，请分段请求
 */
public class TreeGrid {

    private List<Object> children;

    public List<Object> getChildren() {
        return children;
    }

    public void setChildren(List<Object> children) {
        this.children = children;
    }
}
