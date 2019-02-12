package com.colodoo.framework.creater.model;


import java.io.Serializable;

/**
 * @author colodoo
 * @date 2018/08/14 22:05
 * @description 表字段-实体类
 */
public class Column implements Serializable {

    // 字段名
    private String columnName;
    // 字段类型
    private String columnType;
    // 是否可空
    private boolean isNullable;
    // 是否为主键
    private String columnKey;
    // 备注
    private String columnComment;
    // 驼峰字段名
    private String _columnName;

    public String get_columnName() {
        return _columnName;
    }

    public void set_columnName(String _columnName) {
        this._columnName = _columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public boolean isNullable() {
        return isNullable;
    }

    public void setNullable(boolean nullable) {
        isNullable = nullable;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }
}
