package com.colodoo.framework.manager.codeInfo.service;

import com.colodoo.framework.base.abs.BaseService;
import com.colodoo.framework.exception.DAOException;
import com.colodoo.framework.utils.Contants;
import com.colodoo.framework.manager.codeInfo.model.CodeInfo;
import com.colodoo.framework.manager.codeInfo.model.CodeInfoVO;
import com.colodoo.framework.easyui.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.colodoo.framework.manager.codeInfo.service.mapper.CodeInfoSQLMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* @author colodoo
* @date 2019-4-24 22:40:31
* @description 
*/
@Service
@Slf4j
public class CodeInfoService extends BaseService<CodeInfo> {

	@Autowired
	CodeInfoSQLMapper sqlMapper;

    /**
    * 新增数据
    *
    * @param model
    * @return
    */
    public int saveCodeInfo(CodeInfo model) {
        int ret = Contants.CODE_FAILED;
        model.setCodeInfoId(uuid());
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
    public int deleteCodeInfo(CodeInfo model) {
        int ret = Contants.CODE_FAILED;
        try {
            ret = this.delete(model.getCodeInfoId());
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
    public int updateCodeInfo(CodeInfo model) {
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
    public CodeInfo queryById(CodeInfo model) {
        CodeInfo codeInfo = null;
        try {
            codeInfo = this.get(model.getCodeInfoId());
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return codeInfo;
    }

    /**
    * 查找列表
    *
    * @return
    */
    public List<CodeInfo> query(CodeInfoVO model) {
        List<CodeInfo> list = null;
        try {
            list = sqlMapper.getCodeInfoList(model);
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
    public PageInfo<CodeInfo> query(Page page, CodeInfoVO model) {
        PageInfo<CodeInfo> pageInfo;
        List<CodeInfo> list = null;
        PageHelper.startPage(page.getPage(), page.getRows());
        try {
            list = sqlMapper.getCodeInfoList(model);
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        pageInfo = new PageInfo<CodeInfo>(list);
        return pageInfo;
    }
}
