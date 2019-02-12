package com.colodoo.framework.manager.menu.action;

import com.colodoo.framework.easyui.Tree;
import com.colodoo.framework.manager.menu.model.MenuTreeGrid;
import com.colodoo.framework.manager.menu.service.MenuMapper;
import com.colodoo.framework.manager.menu.model.Menu;
import com.colodoo.framework.manager.menu.service.MenuService;
import com.colodoo.framework.easyui.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/menu")
@CrossOrigin
public class MenuAction {

    @Autowired
    MenuService menuService;
    @Autowired
    MenuMapper menuMapper;

    @RequestMapping(value = "/getRootMenuList")
    @ResponseBody
    public Map getRootMenuList(Page page) {
        Map rspMap = new HashMap(2);
        PageInfo pageInfo = menuService.getRootMenuList(page);
        rspMap.put("rows", pageInfo.getList());
        rspMap.put("total", pageInfo.getTotal());
        return rspMap;
    }

    @RequestMapping(value = "/getMenuList")
    @ResponseBody
    public Map getMenuList(Page page) {
        Map rspMap = new HashMap(2);
        PageInfo pageInfo = menuService.getMenuList(page);
        rspMap.put("rows", pageInfo.getList());
        rspMap.put("total", pageInfo.getTotal());
        return rspMap;
    }

    @RequestMapping(value = "/getSubMenuList")
    @ResponseBody
    public List<Tree> getSubMenuList(String parentMenuId) {
        return menuService.getSubMenuList(parentMenuId);
    }

    @RequestMapping(value = "/getMenuTreeGrid")
    @ResponseBody
    public Map getMenuTreeGrid() {
        Map rspMap = new HashMap(2);
        PageInfo pageInfo = menuService.getMenuTreeGrid();
        rspMap.put("rows", pageInfo.getList());
        rspMap.put("total", pageInfo.getTotal());
        return rspMap;
    }

    @RequestMapping(value = "/getSubMenuTreeGrid")
    @ResponseBody
    public List<MenuTreeGrid> getSubMenuTreeGrid() {
        return menuService.getSubMenuTreeGrid("");
    }

    @RequestMapping(value = "/getSubMenuTreeGrid1")
    @ResponseBody
    public Map getSubMenuTreeGrid1(Page page) {
        Map rspMap = new HashMap(2);
        PageInfo pageInfo = menuService.getSubMenuTreeGrid1(page);
        rspMap.put("rows", pageInfo.getList());
        rspMap.put("total", pageInfo.getTotal());
        return rspMap;
    }

    @RequestMapping(value = "/saveMenu")
    @ResponseBody
    public int saveMenu(Menu menu) {
        return menuService.saveMenu(menu);
    }

    @RequestMapping(value = "/editMenu")
    @ResponseBody
    public int editMenu(Menu menu) {
        return menuService.editMenu(menu);
    }

    @RequestMapping(value = "/destroyMenu")
    @ResponseBody
    public Map destroyMenu(Menu menu) {
        HashMap result = new HashMap(1);
        if (menuService.destroyMenu(menu) >= 1) {
            result.put("success", true);
        } else {
            result.put("errorMsg", "删除失败");
        }
        return result;
    }

}
