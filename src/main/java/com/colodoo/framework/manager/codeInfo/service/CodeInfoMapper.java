package com.colodoo.framework.manager.codeInfo.service;

import com.colodoo.framework.manager.codeInfo.model.CodeInfo;
import com.colodoo.framework.manager.codeInfo.model.CodeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeInfoMapper {
    long countByExample(CodeInfoExample example);

    int deleteByExample(CodeInfoExample example);

    int deleteByPrimaryKey(String codeInfoId);

    int insert(CodeInfo record);

    int insertSelective(CodeInfo record);

    List<CodeInfo> selectByExample(CodeInfoExample example);

    CodeInfo selectByPrimaryKey(String codeInfoId);

    int updateByExampleSelective(@Param("record") CodeInfo record, @Param("example") CodeInfoExample example);

    int updateByExample(@Param("record") CodeInfo record, @Param("example") CodeInfoExample example);

    int updateByPrimaryKeySelective(CodeInfo record);

    int updateByPrimaryKey(CodeInfo record);
}