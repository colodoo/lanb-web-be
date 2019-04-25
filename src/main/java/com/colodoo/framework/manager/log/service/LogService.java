package com.colodoo.framework.manager.log.service;

import com.colodoo.framework.base.abs.BaseService;
import com.colodoo.framework.exception.DAOException;
import com.colodoo.framework.utils.Contants;
import com.colodoo.framework.manager.log.model.Log;
import com.colodoo.framework.easyui.Page;
import com.colodoo.framework.manager.log.model.LogExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author colodoo
* @date 2018-8-31 16:14:20
* @description 
*/
@Service
@Slf4j
public class LogService extends BaseService<Log> {

    /**
    * 新增数据
    *
    * @param model
    * @return
    */
    public int saveLog(Log model) {
        int ret = Contants.CODE_FAILED;
        model.setLogId(uuid());
         model.setCreateTime(new Date());
        // model.setLastDate(new Date());
        try {
            ret = this.insert(model);
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return ret;
    }

    /**
    * 删除数据
    *
    * @param model
    * @return
    */
    public int deleteLog(Log model) {
        int ret = Contants.CODE_FAILED;
        try {
            ret = this.delete(model.getLogId());
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return ret;
    }

    /**
    * 更新数据
    *
    * @param model
    * @return
    */
    public int updateLog(Log model) {
        int ret = Contants.CODE_FAILED;
        try {
            ret = this.update(model);
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return ret;
    }

    /**
    * 根据id查找单条数据
    *
    * @param model
    * @return
    */
    public Log queryById(Log model) {
        Log logModel = null;
        try {
            logModel = this.get(model.getLogId());
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return logModel;
    }

    /**
    * 查找列表
    *
    * @return
    */
    public List<Log> query() {
        List<Log> list = null;
        LogExample example = new LogExample();
        try {
            list = this.find(example);
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return list;
    }

    /**
    * 查找分页列表
    *
    * @param page
    * @return
    */
    public PageInfo query(Page page) {
        PageInfo pageInfo;
        List<Log> list = null;
        PageHelper.startPage(page.getPage(), page.getRows());
        try {
            list = this.find();
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
