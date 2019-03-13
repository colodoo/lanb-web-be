package com.colodoo.manager.batch.action;

import com.colodoo.manager.batch.model.Batch;
import com.colodoo.manager.batch.service.BatchService;
import com.colodoo.framework.utils.Contants;
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
* @date 2019-3-13 21:15:30
* @description
*/
@Controller
@RequestMapping(value = "/batch")
@CrossOrigin
public class BatchAction {

    @Autowired
    BatchService batchService;

    @RequestMapping(value = "/batchManager")
    public String batchManager() {
        return "manager/batch/batchManager";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map save(Batch model) {
        Map rspMap = new HashMap();
        int ret = batchService.saveBatch(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", Contants.MSG_SAVE_FAIL);
        }
        return rspMap;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map delete(Batch model) {
        Map rspMap = new HashMap();
        int ret = batchService.deleteBatch(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", Contants.MSG_DELETE_FAIL);
        }
        return rspMap;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map update(Batch model) {
        Map rspMap = new HashMap();
        int ret = batchService.updateBatch(model);
        if(ret > 0) {
            rspMap.put("success", true);
        } else {
            rspMap.put("msg", Contants.MSG_UPDATE_FAIL);
        }
        return rspMap;
    }

    @RequestMapping(value = "/queryById")
    @ResponseBody
    public Map queryById(Batch model) {
        Map rspMap = new HashMap();
        rspMap.put("rows", batchService.queryById(model));
        return rspMap;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<Batch> query() {
        return batchService.query();
    }

    @RequestMapping(value = "/queryPage")
    @ResponseBody
    public Map query(Page page) {
        Map rspMap = new HashMap();
        PageInfo info = batchService.query(page);
        rspMap.put(Contants.TABLE_ROWS, info.getList());
        rspMap.put(Contants.TABLE_TOTAL, info.getTotal());
        return rspMap;
    }
}
