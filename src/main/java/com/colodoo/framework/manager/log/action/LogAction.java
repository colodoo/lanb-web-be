package com.colodoo.framework.manager.log.action;

import com.colodoo.framework.manager.log.model.Log;
import com.colodoo.framework.manager.log.service.LogService;
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
* @date 2018-8-31 16:14:20
* @description
*/
@Controller
@RequestMapping(value = "/log")
@CrossOrigin
public class LogAction {

    @Autowired
    LogService logService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map save(Log model) {
        Map rspMap = new HashMap();
        int ret = logService.saveLog(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "保存失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map delete(Log model) {
        Map rspMap = new HashMap();
        int ret = logService.deleteLog(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "删除失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map update(Log model) {
        Map rspMap = new HashMap();
        int ret = logService.updateLog(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "更新失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Map queryById(Log model) {
        Map rspMap = new HashMap();
        rspMap.put("rows", logService.queryById(model));
        return rspMap;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<Log> query() {
        return logService.query();
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map query(Page page) {
        Map rspMap = new HashMap();
        PageInfo info = logService.query(page);
        rspMap.put("rows", info.getList());
        rspMap.put("total", info.getTotal());
        return rspMap;
    }
}
