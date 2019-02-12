package com.colodoo.framework.manager.config.action;

import com.colodoo.framework.manager.config.model.Config;
import com.colodoo.framework.manager.config.service.ConfigService;
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
* @date 2018-8-30 11:25:25
* @description
*/
@Controller
@RequestMapping(value = "/config")
@CrossOrigin
public class ConfigAction {

    @Autowired
    ConfigService configService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map save(Config model) {
        Map rspMap = new HashMap();
        int ret = configService.saveConfig(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "保存失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map delete(Config model) {
        Map rspMap = new HashMap();
        int ret = configService.deleteConfig(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "删除失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map update(Config model) {
        Map rspMap = new HashMap();
        int ret = configService.updateConfig(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "更新失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Map queryById(Config model) {
        Map rspMap = new HashMap();
        rspMap.put("rows", configService.queryById(model));
        return rspMap;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<Config> query() {
        return configService.query();
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map query(Page page) {
        Map rspMap = new HashMap();
        PageInfo info = configService.query(page);
        rspMap.put("rows", info.getList());
        rspMap.put("total", info.getTotal());
        return rspMap;
    }
}
