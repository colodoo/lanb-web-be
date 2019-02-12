package com.colodoo.framework.manager.roleUser.service;

import com.colodoo.framework.manager.roleUser.model.RoleUser;
import com.colodoo.framework.manager.roleUser.model.RoleUserExample;
import java.util.List;

import com.colodoo.framework.manager.roleUser.model.RoleUserVO;
import org.apache.ibatis.annotations.Param;

public interface RoleUserMapper {
    long countByExample(RoleUserExample example);

    int deleteByExample(RoleUserExample example);

    int deleteByPrimaryKey(String roleUserId);

    int insert(RoleUser record);

    int insertSelective(RoleUser record);

    List<RoleUser> selectByExample(RoleUserExample example);

    List<RoleUserVO> select();

    RoleUser selectByPrimaryKey(String roleUserId);

    int updateByExampleSelective(@Param("record") RoleUser record, @Param("example") RoleUserExample example);

    int updateByExample(@Param("record") RoleUser record, @Param("example") RoleUserExample example);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);
}