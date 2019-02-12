package com.colodoo.framework.manager.codeType.service;

import com.colodoo.framework.manager.codeType.model.CodeType;
import com.colodoo.framework.utils.StringUtil;
import com.colodoo.framework.easyui.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeTypeService {

    @Autowired
    CodeTypeMapper codeTypeMapper;

    public int save(CodeType model) {
    model.setCodeTypeId(StringUtil.uuid());
        return codeTypeMapper.insert(model);
    }

    public int delete(CodeType model) {
        return codeTypeMapper.deleteByPrimaryKey(model.getCodeTypeId());
    }

    public int update(CodeType model) {
        return codeTypeMapper.updateByPrimaryKey(model);
    }

    public CodeType queryById(CodeType model) {
        return codeTypeMapper.selectByPrimaryKey(model.getCodeTypeId());
    }

    public List<CodeType> query() {
        return codeTypeMapper.selectByExample(null);
    }

    public PageInfo query(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return new PageInfo(codeTypeMapper.selectByExample(null));
    }
}
