package com.colodoo.manager.batch.service;

import com.colodoo.framework.base.abs.BaseService;
import com.colodoo.framework.exception.DAOException;
import com.colodoo.framework.utils.Contants;
import com.colodoo.manager.batch.model.Batch;
import com.colodoo.framework.easyui.Page;
import com.colodoo.manager.batch.model.BatchExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author colodoo
* @date 2019-3-13 21:15:30
* @description 
*/
@Service
@Slf4j
public class BatchService extends BaseService<Batch> {

    /**
    * 新增数据
    *
    * @param model
    * @return
    */
    public int saveBatch(Batch model) {
        int ret = Contants.CODE_FAILED;
        model.setBatchId(uuid());
        // model.setCreateDate(new Date());
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
    public int deleteBatch(Batch model) {
        int ret = Contants.CODE_FAILED;
        try {
            ret = this.delete(model.getBatchId());
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
    public int updateBatch(Batch model) {
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
    public Batch queryById(Batch model) {
        Batch batch = null;
        try {
            batch = this.get(model.getBatchId());
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return batch;
    }

    /**
    * 查找列表
    *
    * @return
    */
    public List<Batch> query() {
        List<Batch> list = null;
        BatchExample example = new BatchExample();
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
        List<Batch> list = null;
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
