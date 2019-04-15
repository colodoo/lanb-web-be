package com.colodoo.framework.manager.codeType.service;

import com.colodoo.framework.manager.codeType.model.CodeType;
import com.colodoo.framework.manager.codeType.model.CodeTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeTypeMapper {
    /**
     *
     * @mbg.generated 2019-04-15
     */
    long countByExample(CodeTypeExample example);

    /**
     *
     * @mbg.generated 2019-04-15
     */
    int deleteByExample(CodeTypeExample example);

    /**
     *
     * @mbg.generated 2019-04-15
     */
    int deleteByPrimaryKey(String codeTypeId);

    /**
     *
     * @mbg.generated 2019-04-15
     */
    int insert(CodeType record);

    /**
     *
     * @mbg.generated 2019-04-15
     */
    int insertSelective(CodeType record);

    /**
     *
     * @mbg.generated 2019-04-15
     */
    List<CodeType> selectByExample(CodeTypeExample example);

    /**
     *
     * @mbg.generated 2019-04-15
     */
    CodeType selectByPrimaryKey(String codeTypeId);

    /**
     *
     * @mbg.generated 2019-04-15
     */
    int updateByExampleSelective(@Param("record") CodeType record, @Param("example") CodeTypeExample example);

    /**
     *
     * @mbg.generated 2019-04-15
     */
    int updateByExample(@Param("record") CodeType record, @Param("example") CodeTypeExample example);

    /**
     *
     * @mbg.generated 2019-04-15
     */
    int updateByPrimaryKeySelective(CodeType record);

    /**
     *
     * @mbg.generated 2019-04-15
     */
    int updateByPrimaryKey(CodeType record);
}