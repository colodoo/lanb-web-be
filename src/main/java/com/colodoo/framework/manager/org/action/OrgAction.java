package com.colodoo.framework.manager.org.action;

import com.colodoo.framework.manager.org.model.Org;
import com.colodoo.framework.manager.org.service.OrgService;
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
* @date 2018-8-28 17:31:35
* @description
*/
@Controller
@RequestMapping(value = "/org")
@CrossOrigin
public class OrgAction {

    @Autowired
    OrgService orgService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map save(Org model) {
        Map rspMap = new HashMap();
        int ret = orgService.saveOrg(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "保存失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map delete(Org model) {
        Map rspMap = new HashMap();
        int ret = orgService.deleteOrg(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "删除失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map update(Org model) {
        Map rspMap = new HashMap();
        int ret = orgService.updateOrg(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "更新失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Map queryById(Org model) {
        Map rspMap = new HashMap();
        rspMap.put("rows", orgService.queryById(model));
        return rspMap;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<Org> query() {
        return orgService.query();
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map query(Page page) {
        Map rspMap = new HashMap();
        PageInfo info = orgService.query(page);
        rspMap.put("rows", info.getList());
        rspMap.put("total", info.getTotal());
        return rspMap;
    }
}
