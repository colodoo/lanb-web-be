package com.colodoo.framework.manager.role.action;

import com.colodoo.framework.manager.role.model.Role;
import com.colodoo.framework.manager.role.service.RoleService;
import com.colodoo.framework.easyui.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
* @author colodoo
* @date 2018-8-29 23:20:14
* @description
*/
@Controller
@RequestMapping(value = "/role")
@CrossOrigin
public class RoleAction {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map save(Role model) {
        Map rspMap = new HashMap();
        int ret = roleService.saveRole(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "保存失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map delete(Role model) {
        Map rspMap = new HashMap();
        int ret = roleService.deleteRole(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "删除失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map update(Role model) {
        Map rspMap = new HashMap();
        int ret = roleService.updateRole(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "更新失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Map queryById(Role model) {
        Map rspMap = new HashMap();
        rspMap.put("rows", roleService.queryById(model));
        return rspMap;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<Role> query() {
        return roleService.query();
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map query(Page page) {
        Map rspMap = new HashMap();
        PageInfo info = roleService.query(page);
        rspMap.put("rows", info.getList());
        rspMap.put("total", info.getTotal());
        return rspMap;
    }
}
