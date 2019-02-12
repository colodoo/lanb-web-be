package com.colodoo.framework.manager.codeType.action;

import com.colodoo.framework.manager.codeType.model.CodeType;
import com.colodoo.framework.manager.codeType.service.CodeTypeService;
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
@RequestMapping(value = "/codeType")
public class CodeTypeAction {

    @Autowired
    CodeTypeService codeTypeService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map save(CodeType model) {
        Map rspMap = new HashMap();
        int ret = codeTypeService.save(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "保存失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map delete(CodeType model) {
        Map rspMap = new HashMap();
        int ret = codeTypeService.delete(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "删除失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map update(CodeType model) {
        Map rspMap = new HashMap();
        int ret = codeTypeService.update(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", "更新失败");
        }
        return rspMap;
    }

    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Map queryById(CodeType model) {
        Map rspMap = new HashMap();
        rspMap.put("rows", codeTypeService.queryById(model));
        return rspMap;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<CodeType> query() {
        return codeTypeService.query();
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map query(Page page) {
        Map rspMap = new HashMap();
        PageInfo info = codeTypeService.query(page);
        rspMap.put("rows", info.getList());
        rspMap.put("total", info.getTotal());
        return rspMap;
    }
}
