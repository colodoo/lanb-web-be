package com.colodoo.framework.manager.roleUser.action;

import com.colodoo.framework.manager.roleUser.model.RoleUser;
import com.colodoo.framework.manager.roleUser.model.RoleUserVO;
import com.colodoo.framework.manager.roleUser.service.RoleUserService;
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
* @date 2018-8-28 17:42:38
* @description
*/
@Controller
@RequestMapping(value = "/roleUser")
public class RoleUserAction {

    @Autowired
    RoleUserService roleUserService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map save(RoleUser model) {
        Map rspMap = new HashMap();
        int ret = roleUserService.saveRoleUser(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "保存失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map delete(RoleUser model) {
        Map rspMap = new HashMap();
        int ret = roleUserService.deleteRoleUser(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "删除失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map update(RoleUser model) {
        Map rspMap = new HashMap();
        int ret = roleUserService.updateRoleUser(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "更新失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Map queryById(RoleUser model) {
        Map rspMap = new HashMap();
        rspMap.put("rows", roleUserService.queryById(model));
        return rspMap;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<RoleUserVO> query() {
        return roleUserService.query();
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map query(Page page) {
        Map rspMap = new HashMap();
        PageInfo info = roleUserService.query(page);
        rspMap.put("rows", info.getList());
        rspMap.put("total", info.getTotal());
        return rspMap;
    }
}
