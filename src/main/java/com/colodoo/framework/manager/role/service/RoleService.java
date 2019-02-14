package com.colodoo.framework.manager.role.service;

import com.colodoo.framework.base.abs.BaseService;
import com.colodoo.framework.exception.DAOException;
import com.colodoo.framework.utils.Contants;
import com.colodoo.framework.manager.role.model.Role;
import com.colodoo.framework.easyui.Page;
import com.colodoo.framework.manager.role.model.RoleExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author colodoo
* @date 2018-8-29 23:20:14
* @description 
*/
@Service
@Slf4j
public class RoleService extends BaseService<Role> {

    /**
    * 新增数据
    *
    * @param model
    * @return
    */
    public int saveRole(Role model) {
        int ret = Contants.CODE_FAILED;
        // model.setRoleId(uuid());
        model.setRoleId(model.getRoleName());
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
    public int deleteRole(Role model) {
        int ret = Contants.CODE_FAILED;
        try {
            ret = this.delete(model.getRoleId());
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
    public int updateRole(Role model) {
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
    public Role queryById(Role model) {
        Role role = null;
        try {
            role = this.get(model.getRoleId());
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return role;
    }

    /**
    * 查找列表
    *
    * @return
    */
    public List<Role> query() {
        List<Role> list = null;
        RoleExample example = new RoleExample();
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
        List<Role> list = null;
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
