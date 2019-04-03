package com.colodoo.manager.test.action;

import com.colodoo.manager.test.model.Test;
import com.colodoo.manager.test.model.TestVO;
import com.colodoo.manager.test.service.TestService;
import com.colodoo.framework.utils.Contants;
import com.colodoo.framework.easyui.Page;
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
* @date 2019-4-3 10:04:05
* @description
*/
@Controller
@RequestMapping(value = "/test")
@CrossOrigin
public class TestAction {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map<String, Object> save(@RequestBody Test model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        int ret = testService.saveTest(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", Contants.MSG_SAVE_FAIL);
        }
        return rspMap;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestBody Test model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        int ret = testService.deleteTest(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", Contants.MSG_DELETE_FAIL);
        }
        return rspMap;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map<String, Object> update(@RequestBody Test model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        int ret = testService.updateTest(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", Contants.MSG_UPDATE_FAIL);
        }
        return rspMap;
    }

    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Map<String, Object> queryById(@RequestBody Test model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        rspMap.put("rows", testService.queryById(model));
        return rspMap;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<Test> query(@RequestBody TestVO model) {
        return testService.query(model);
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map<String, Object> queryPage(@RequestBody TestVO model) {
        Map<String, Object> rspMap = new HashMap<String, Object>();
        PageInfo<Test> info = testService.query(model.getPage(), model);
        rspMap.put(Contants.TABLE_ROWS, info.getList());
        rspMap.put(Contants.TABLE_TOTAL, info.getTotal());
        return rspMap;
    }
}
