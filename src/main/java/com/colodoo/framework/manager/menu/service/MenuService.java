package com.colodoo.framework.manager.menu.service;

import com.alibaba.fastjson.JSONObject;
import com.colodoo.framework.easyui.Tree;
import com.colodoo.framework.manager.menu.model.Menu;
import com.colodoo.framework.manager.menu.model.MenuExample;
import com.colodoo.framework.manager.menu.model.MenuTreeGrid;
import com.colodoo.framework.easyui.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public PageInfo getRootMenuList(Page page) {
        MenuExample example = new MenuExample();
        example.createCriteria().andParentMenuIdEqualTo("");
        example.setOrderByClause("sort");
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Menu> list = menuMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public PageInfo getMenuList(Page page) {
        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getRows());
        }
        List<Menu> list = menuMapper.selectByExample(null);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public List<Tree> getSubMenuList(String parentMenuId) {
        if (parentMenuId == null) {
            parentMenuId = "";
        }
        List<Tree> list = new ArrayList<Tree>();
        MenuExample example = new MenuExample();
        example.setOrderByClause("sort");
        example.createCriteria().andParentMenuIdEqualTo(parentMenuId);
        List<Menu> menus = menuMapper.selectByExample(example);
        for (Menu menu : menus) {
            Tree tree = new Tree();
            tree.setText(menu.getMenuName());
            tree.setId(menu.getMenuId());
            tree.setChecked(false);
            tree.setState("close");
            HashMap<String, String> attr = new HashMap<String, String>();
            attr.put("menuUrl", menu.getMenuUrl());
            tree.setAttributes(attr);
            List tempList = getSubMenuList(tree.getId());
            if(tempList.size() != 0) {
                tree.setChildren(tempList);
            }
            list.add(tree);
        }
        return list;
    }

    public PageInfo getMenuTreeGrid() {
        List<MenuTreeGrid> list = getSubMenuTreeGrid("");
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 取树数据
     *
     * @param parentMenuId
     * @return
     */
    public List<MenuTreeGrid> getSubMenuTreeGrid(String parentMenuId) {
        if (parentMenuId == null) {
            parentMenuId = "";
        }
        List<MenuTreeGrid> list = new ArrayList<MenuTreeGrid>();
        MenuExample example = new MenuExample();
        example.createCriteria().andParentMenuIdEqualTo(parentMenuId);
        example.setOrderByClause("sort");
        List<Menu> menus = menuMapper.selectByExample(example);
        for (Menu menu : menus) {
            String menuStr = JSONObject.toJSONString(menu);
            MenuTreeGrid menuTreeGrid = JSONObject.parseObject(menuStr, MenuTreeGrid.class);
            menuTreeGrid.set_parentId(menu.getParentMenuId());
            menuTreeGrid.setChildren(getSubMenuTreeGrid(menuTreeGrid.getMenuId()));
            list.add(menuTreeGrid);
        }
        return list;
    }

    /**
     * 取树数据1
     *
     * @param page
     * @return
     */
    public PageInfo getSubMenuTreeGrid1(Page page) {
        List<MenuTreeGrid> list = new ArrayList<MenuTreeGrid>();
        if (page != null) {
            PageHelper.startPage(page.getPage(), page.getRows());
        }
        MenuExample example = new MenuExample();
        example.setOrderByClause("sort");
        List<Menu> menus = menuMapper.selectByExample(example);
        for (Menu menu : menus) {
            String menuStr = JSONObject.toJSONString(menu);
            MenuTreeGrid menuTreeGrid = JSONObject.parseObject(menuStr, MenuTreeGrid.class);
            menuTreeGrid.setState("close");
            if (!"".equals(menu.getParentMenuId())) {
                menuTreeGrid.set_parentId(menu.getParentMenuId());
            } else {
                menuTreeGrid.set_parentId(null);
            }
            list.add(menuTreeGrid);
        }
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public int saveMenu(Menu menu) {
        menu.setMenuId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        if (menu.getSort() == null) {
            menu.setSort(0);
        }
        return menuMapper.insert(menu);
    }

    public int editMenu(Menu menu) {
        return menuMapper.updateByPrimaryKey(menu);
    }

    public int destroyMenu(Menu menu) {
        MenuExample example = new MenuExample();
        example.createCriteria().andMenuIdEqualTo(menu.getMenuId());
        return menuMapper.deleteByExample(example);
    }

}
