package com.colodoo.framework.manager.menu.service;

import com.colodoo.framework.manager.menu.model.Menu;
import com.colodoo.framework.manager.menu.model.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    /**
     *
     * @mbg.generated 2019-04-24
     */
    long countByExample(MenuExample example);

    /**
     *
     * @mbg.generated 2019-04-24
     */
    int deleteByExample(MenuExample example);

    /**
     *
     * @mbg.generated 2019-04-24
     */
    int deleteByPrimaryKey(String menuId);

    /**
     *
     * @mbg.generated 2019-04-24
     */
    int insert(Menu record);

    /**
     *
     * @mbg.generated 2019-04-24
     */
    int insertSelective(Menu record);

    /**
     *
     * @mbg.generated 2019-04-24
     */
    List<Menu> selectByExample(MenuExample example);

    /**
     *
     * @mbg.generated 2019-04-24
     */
    Menu selectByPrimaryKey(String menuId);

    /**
     *
     * @mbg.generated 2019-04-24
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     *
     * @mbg.generated 2019-04-24
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     *
     * @mbg.generated 2019-04-24
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     *
     * @mbg.generated 2019-04-24
     */
    int updateByPrimaryKey(Menu record);
}