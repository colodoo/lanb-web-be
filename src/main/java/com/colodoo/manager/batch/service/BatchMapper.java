package com.colodoo.manager.batch.service;

import com.colodoo.manager.batch.model.Batch;
import com.colodoo.manager.batch.model.BatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchMapper {
    long countByExample(BatchExample example);

    int deleteByExample(BatchExample example);

    int deleteByPrimaryKey(String batchId);

    int insert(Batch record);

    int insertSelective(Batch record);

    List<Batch> selectByExample(BatchExample example);

    Batch selectByPrimaryKey(String batchId);

    int updateByExampleSelective(@Param("record") Batch record, @Param("example") BatchExample example);

    int updateByExample(@Param("record") Batch record, @Param("example") BatchExample example);

    int updateByPrimaryKeySelective(Batch record);

    int updateByPrimaryKey(Batch record);
}