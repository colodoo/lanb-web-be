package com.colodoo.framework.manager.codeInfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class CodeInfo {
    /**
     * 代码信息ID
     */
    private String codeInfoId;

    /**
     * 代码类型ID
     */
    private String codeTypeId;

    /**
     * 代码名
     */
    private String name;

    /**
     * 代码值
     */
    private String value;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 代码信息ID
     * @return code_info_id 代码信息ID
     */
    public String getCodeInfoId() {
        return codeInfoId;
    }

    /**
     * 代码信息ID
     * @param codeInfoId 代码信息ID
     */
    public void setCodeInfoId(String codeInfoId) {
        this.codeInfoId = codeInfoId == null ? null : codeInfoId.trim();
    }

    /**
     * 代码类型ID
     * @return code_type_id 代码类型ID
     */
    public String getCodeTypeId() {
        return codeTypeId;
    }

    /**
     * 代码类型ID
     * @param codeTypeId 代码类型ID
     */
    public void setCodeTypeId(String codeTypeId) {
        this.codeTypeId = codeTypeId == null ? null : codeTypeId.trim();
    }

    /**
     * 代码名
     * @return name 代码名
     */
    public String getName() {
        return name;
    }

    /**
     * 代码名
     * @param name 代码名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 代码值
     * @return value 代码值
     */
    public String getValue() {
        return value;
    }

    /**
     * 代码值
     * @param value 代码值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 排序
     * @return sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}