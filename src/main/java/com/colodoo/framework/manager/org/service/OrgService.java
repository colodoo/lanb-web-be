package com.colodoo.framework.manager.org.service;

import com.colodoo.framework.base.abs.BaseService;
import com.colodoo.framework.exception.DAOException;
import com.colodoo.framework.utils.Contants;
import com.colodoo.framework.manager.org.model.Org;
import com.colodoo.framework.easyui.Page;
import com.colodoo.framework.manager.org.model.OrgExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author colodoo
* @date 2018-8-28 17:31:35
* @description 
*/
@Service
@Slf4j
public class OrgService extends BaseService<Org> {

    /**
    * 新增数据
    *
    * @param model
    * @return
    */
    public int saveOrg(Org model) {
        int ret = Contants.CODE_FAILED;
        model.setOrgId(uuid());
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
    public int deleteOrg(Org model) {
        int ret = Contants.CODE_FAILED;
        try {
            ret = this.delete(model.getOrgId());
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
    public int updateOrg(Org model) {
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
    public Org queryById(Org model) {
        Org org = null;
        try {
            org = this.get(model.getOrgId());
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return org;
    }

    /**
    * 查找列表
    *
    * @return
    */
    public List<Org> query() {
        List<Org> list = null;
        OrgExample example = new OrgExample();
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
        List<Org> list = null;
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
