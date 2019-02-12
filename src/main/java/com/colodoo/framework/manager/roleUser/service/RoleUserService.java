package com.colodoo.framework.manager.roleUser.service;

import com.colodoo.framework.base.abs.BaseService;
import com.colodoo.framework.exception.DAOException;
import com.colodoo.framework.manager.roleUser.model.RoleUserVO;
import com.colodoo.framework.utils.Contants;
import com.colodoo.framework.manager.roleUser.model.RoleUser;
import com.colodoo.framework.easyui.Page;
import com.colodoo.framework.manager.roleUser.model.RoleUserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author colodoo
 * @date 2018-8-28 17:42:38
 * @description
 */
@Service
@Slf4j
public class RoleUserService extends BaseService<RoleUser> {

    @Autowired
    RoleUserMapper roleUserMapper;

    /**
     * 新增数据
     *
     * @param model
     * @return
     */
    public int saveRoleUser(RoleUser model) {
        int ret = Contants.CODE_FAILED;
        model.setRoleUserId(uuid());
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
    public int deleteRoleUser(RoleUser model) {
        int ret = Contants.CODE_FAILED;
        try {
            ret = this.delete(model.getRoleUserId());
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
    public int updateRoleUser(RoleUser model) {
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
    public RoleUser queryById(RoleUser model) {
        RoleUser roleUser = null;
        try {
            roleUser = this.get(model.getRoleUserId());
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return roleUser;
    }

    /**
     * 查找列表
     *
     * @return
     */
    public List<RoleUserVO> query() {
        List<RoleUserVO> list = null;
        // list = this.select("select", null);
        list = roleUserMapper.select();
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
        List<RoleUser> list = null;
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
