package com.colodoo.framework.manager.codeInfo.action;

import com.colodoo.framework.manager.codeInfo.model.CodeInfo;
import com.colodoo.framework.manager.codeInfo.service.CodeInfoService;
import com.colodoo.framework.easyui.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Controller
@RequestMapping(value = "/codeInfo")
public class CodeInfoAction {

    @Autowired
    CodeInfoService codeInfoService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map save(CodeInfo model) {
        Map rspMap = new HashMap();
        int ret = codeInfoService.save(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "保存失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map delete(CodeInfo model) {
        Map rspMap = new HashMap();
        int ret = codeInfoService.delete(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "删除失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map update(CodeInfo model) {
        Map rspMap = new HashMap();
        int ret = codeInfoService.update(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "更新失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Map queryById(CodeInfo model) {
        Map rspMap = new HashMap();
        rspMap.put("rows", codeInfoService.queryById(model));
        return rspMap;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<CodeInfo> query(CodeInfo model, Page page) {
        return codeInfoService.query(model);
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map query(Page page) {
        Map rspMap = new HashMap();
        PageInfo info = codeInfoService.query(page);
        rspMap.put("rows", info.getList());
        rspMap.put("total", info.getTotal());
        return rspMap;
    }
}
