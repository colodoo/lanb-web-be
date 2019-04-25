package com.colodoo.framework.manager.codeType.service;

import com.colodoo.framework.base.abs.BaseService;
import com.colodoo.framework.exception.DAOException;
import com.colodoo.framework.utils.Contants;
import com.colodoo.framework.manager.codeType.model.CodeType;
import com.colodoo.framework.manager.codeType.model.CodeTypeVO;
import com.colodoo.framework.easyui.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.colodoo.framework.manager.codeType.service.mapper.CodeTypeSQLMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* @author colodoo
* @date 2019-4-18 21:55:03
* @description 
*/
@Service
@Slf4j
public class CodeTypeService extends BaseService<CodeType> {

	@Autowired
	CodeTypeSQLMapper sqlMapper;

    /**
    * 新增数据
    *
    * @param model
    * @return
    */
    public int saveCodeType(CodeType model) {
        int ret = Contants.CODE_FAILED;
        model.setCodeTypeId(uuid());
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
    public int deleteCodeType(CodeType model) {
        int ret = Contants.CODE_FAILED;
        try {
            ret = this.delete(model.getCodeTypeId());
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
    public int updateCodeType(CodeType model) {
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
    public CodeType queryById(CodeType model) {
        CodeType codeType = null;
        try {
            codeType = this.get(model.getCodeTypeId());
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        return codeType;
    }

    /**
    * 查找列表
    *
    * @return
    */
    public List<CodeType> query(CodeTypeVO model) {
        List<CodeType> list = null;
        try {
            list = sqlMapper.getCodeTypeList(model);
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
    public PageInfo<CodeType> query(Page page, CodeTypeVO model) {
        PageInfo<CodeType> pageInfo;
        List<CodeType> list = null;
        PageHelper.startPage(page.getPage(), page.getRows());
        try {
            list = sqlMapper.getCodeTypeList(model);
        } catch (DAOException e) {
            log.error(e.getMsg());
        }
        pageInfo = new PageInfo<CodeType>(list);
        return pageInfo;
    }
}
