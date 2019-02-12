package com.colodoo.framework.manager.codeInfo.model;

public class CodeInfo {
    private String codeInfoId;
    private String codeTypeId;
    private String name;
    private String value;
    private Integer sort;

    private String codeTypeName;

    public String getCodeTypeName() {
        return codeTypeName;
    }

    public void setCodeTypeName(String codeTypeName) {
        this.codeTypeName = codeTypeName;
    }

    public String getCodeInfoId() {
        return codeInfoId;
    }

    public void setCodeInfoId(String codeInfoId) {
        this.codeInfoId = codeInfoId == null ? null : codeInfoId.trim();
    }

    public String getCodeTypeId() {
        return codeTypeId;
    }

    public void setCodeTypeId(String codeTypeId) {
        this.codeTypeId = codeTypeId == null ? null : codeTypeId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}