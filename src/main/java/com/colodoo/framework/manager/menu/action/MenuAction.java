package com.colodoo.framework.manager.menu.action;

import com.colodoo.framework.easyui.Tree;
import com.colodoo.framework.manager.menu.model.Menu;
import com.colodoo.framework.manager.menu.model.MenuVO;
import com.colodoo.framework.manager.menu.service.MenuService;
import com.colodoo.framework.utils.Contants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
* @author colodoo
* @date 2019-4-24 22:32:53
* @description
*/
@Controller
@RequestMapping(value = "/menu")
@CrossOrigin
public class MenuAction {

    @Autowired
    MenuService menuService;

	/**
	 * 新增数据
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/save")
    @ResponseBody
    public Map<String, Object> save(@RequestBody Menu model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        int ret = menuService.saveMenu(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", Contants.MSG_SAVE_FAIL);
        }
        return rspMap;
    }

	/**
	 * 删除数据
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestBody Menu model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        int ret = menuService.deleteMenu(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", Contants.MSG_DELETE_FAIL);
        }
        return rspMap;
    }

	/**
	 * 更新数据
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Map<String, Object> update(@RequestBody Menu model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        int ret = menuService.updateMenu(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", Contants.MSG_UPDATE_FAIL);
        }
        return rspMap;
    }

	/**
	 * 根据id查找单条数据
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Map<String, Object> queryById(@RequestBody Menu model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        rspMap.put("rows", menuService.queryById(model));
        return rspMap;
    }

	/**
	 * 查找列表
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/query")
    @ResponseBody
    public List<Menu> query(@RequestBody MenuVO model) {
        return menuService.query(model);
    }

	/**
	 * 查找分页列表
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map<String, Object> queryPage(@RequestBody MenuVO model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        PageInfo<Menu> info = menuService.query(model.getPage(), model);
        rspMap.put(Contants.TABLE_ROWS, info.getList());
        rspMap.put(Contants.TABLE_TOTAL, info.getTotal());
        return rspMap;
    }
    
    /**
	 * 查找列表
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/getTreeMenu")
    @ResponseBody
    public List<Tree> getTreeMenu(@RequestBody MenuVO model) {
        return menuService.getTreeMenu(model.getParentMenuId());
    }
}
