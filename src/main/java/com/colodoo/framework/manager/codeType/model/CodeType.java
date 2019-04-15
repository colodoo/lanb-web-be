package com.colodoo.framework.manager.codeType.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class CodeType {
    /**
     * 代码类型ID
     */
    private String codeTypeId;

    /**
     * 代码类型名
     */
    private String codeTypeName;

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
     * 代码类型名
     * @return code_type_name 代码类型名
     */
    public String getCodeTypeName() {
        return codeTypeName;
    }

    /**
     * 代码类型名
     * @param codeTypeName 代码类型名
     */
    public void setCodeTypeName(String codeTypeName) {
        this.codeTypeName = codeTypeName == null ? null : codeTypeName.trim();
    }
}