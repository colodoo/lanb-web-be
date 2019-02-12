package com.colodoo.framework.manager.msg.service;

import com.colodoo.framework.base.abs.BaseService;
import com.colodoo.framework.exception.DAOException;
import com.colodoo.framework.utils.Contants;
import com.colodoo.framework.manager.msg.model.Msg;
import com.colodoo.framework.easyui.Page;
import com.colodoo.framework.manager.msg.model.MsgExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author colodoo
* @date 2018-8-31 16:56:31
* @description 
*/
@Service
@Slf4j
public class MsgService extends BaseService<Msg> {

    /**
    * 新增数据
    *
    * @param model
    * @return
    */
    public int saveMsg(Msg model) {
        int ret = Contants.CODE_FAILED;
        model.setMsgId(uuid());
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
    public int deleteMsg(Msg model) {
        int ret = Contants.CODE_FAILED;
        try {
            ret = this.delete(model.getMsgId());
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
    public int updateMsg(Msg model) {
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
    public Msg queryById(Msg model) {
        Msg msg = null;
        try {
            msg = this.get(model.getMsgId());
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return msg;
    }

    /**
    * 查找列表
    *
    * @return
    */
    public List<Msg> query() {
        List<Msg> list = null;
        MsgExample example = new MsgExample();
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
        List<Msg> list = null;
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
