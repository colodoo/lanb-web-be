package com.colodoo.framework.manager.menu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class Menu {
    /**
     * 菜单ID
     */
    private String menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 父菜单ID
     */
    private String parentMenuId;

    /**
     * 菜单地址
     */
    private String menuUrl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否可见
     */
    private Integer visible;

    /**
     * 菜单ID
     * @return menu_id 菜单ID
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 菜单ID
     * @param menuId 菜单ID
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    /**
     * 菜单名称
     * @return menu_name 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 菜单名称
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 父菜单ID
     * @return parent_menu_id 父菜单ID
     */
    public String getParentMenuId() {
        return parentMenuId;
    }

    /**
     * 父菜单ID
     * @param parentMenuId 父菜单ID
     */
    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId == null ? null : parentMenuId.trim();
    }

    /**
     * 菜单地址
     * @return menu_url 菜单地址
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 菜单地址
     * @param menuUrl 菜单地址
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
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

    /**
     * 是否可见
     * @return visible 是否可见
     */
    public Integer getVisible() {
        return visible;
    }

    /**
     * 是否可见
     * @param visible 是否可见
     */
    public void setVisible(Integer visible) {
        this.visible = visible;
    }
}