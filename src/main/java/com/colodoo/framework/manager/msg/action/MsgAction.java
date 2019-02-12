package com.colodoo.framework.manager.msg.action;

import com.colodoo.framework.manager.msg.model.Msg;
import com.colodoo.framework.manager.msg.service.MsgService;
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
* @date 2018-8-31 16:56:31
* @description
*/
@Controller
@RequestMapping(value = "/msg")
@CrossOrigin
public class MsgAction {

    @Autowired
    MsgService msgService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map save(Msg model) {
        Map rspMap = new HashMap();
        int ret = msgService.saveMsg(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "保存失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map delete(Msg model) {
        Map rspMap = new HashMap();
        int ret = msgService.deleteMsg(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "删除失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map update(Msg model) {
        Map rspMap = new HashMap();
        int ret = msgService.updateMsg(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "更新失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Map queryById(Msg model) {
        Map rspMap = new HashMap();
        rspMap.put("rows", msgService.queryById(model));
        return rspMap;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<Msg> query() {
        return msgService.query();
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map query(Page page) {
        Map rspMap = new HashMap();
        PageInfo info = msgService.query(page);
        rspMap.put("rows", info.getList());
        rspMap.put("total", info.getTotal());
        return rspMap;
    }
}
