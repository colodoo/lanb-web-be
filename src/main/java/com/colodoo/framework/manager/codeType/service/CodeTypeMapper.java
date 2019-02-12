package com.colodoo.framework.manager.codeType.service;

import com.colodoo.framework.manager.codeType.model.CodeType;
import com.colodoo.framework.manager.codeType.model.CodeTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeTypeMapper {
    long countByExample(CodeTypeExample example);

    int deleteByExample(CodeTypeExample example);

    int deleteByPrimaryKey(String codeTypeId);

    int insert(CodeType record);

    int insertSelective(CodeType record);

    List<CodeType> selectByExample(CodeTypeExample example);

    CodeType selectByPrimaryKey(String codeTypeId);

    int updateByExampleSelective(@Param("record") CodeType record, @Param("example") CodeTypeExample example);

    int updateByExample(@Param("record") CodeType record, @Param("example") CodeTypeExample example);

    int updateByPrimaryKeySelective(CodeType record);

    int updateByPrimaryKey(CodeType record);
}