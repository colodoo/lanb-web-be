package com.colodoo.manager.test.action;

import com.colodoo.framework.common.Msg;
import com.colodoo.framework.utils.Contants;
import com.colodoo.manager.test.model.Test;
import com.colodoo.manager.test.service.TestService;
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
 * @date 2018-8-30 10:41:40
 * @description
 */
@Controller
@RequestMapping(value = "/test")
@CrossOrigin
public class TestAction {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/testManager")
    public String testManager() {
        return "manager/test/testManager";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public Msg save(Test model) {
        Msg msg = new Msg();
        int ret = testService.saveTest(model);
        if (ret > 0) {
            msg.setSuccess(true);
        } else {
            msg.setMsg(Contants.MSG_SAVE_FAIL);
        }
        return msg;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Msg delete(Test model) {
        Msg msg = new Msg();
        int ret = testService.deleteTest(model);
        if (ret > 0) {
            msg.setSuccess(true);
        } else {
            msg.setMsg(Contants.MSG_DELETE_FAIL);
        }
        return msg;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Msg update(Test model) {
        Msg msg = new Msg();
        int ret = testService.updateTest(model);
        if (ret > 0) {
            msg.setSuccess(true);
        } else {
            msg.setMsg(Contants.MSG_UPDATE_FAIL);
        }
        return msg;
    }

    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Msg queryById(Test model) {
        Msg msg = new Msg();
        msg.setData(testService.queryById(model));
        return msg;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<Test> query() {
        return testService.query();
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map query(Page page) {
        Map rspMap = new HashMap();
        PageInfo info = testService.query(page);
        rspMap.put(Contants.TABLE_ROWS, info.getList());
        rspMap.put(Contants.TABLE_TOTAL, info.getTotal());
        return rspMap;
    }
}
