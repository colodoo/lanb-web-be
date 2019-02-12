package com.colodoo.framework.manager.codeInfo.service;

import com.colodoo.framework.manager.codeInfo.model.CodeInfo;
import com.colodoo.framework.utils.StringUtil;
import com.colodoo.framework.easyui.Page;
import com.colodoo.framework.manager.codeInfo.model.CodeInfoExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeInfoService {

    @Autowired
    CodeInfoMapper codeInfoMapper;

    public int save(CodeInfo model) {
    model.setCodeInfoId(StringUtil.uuid());
        return codeInfoMapper.insert(model);
    }

    public int delete(CodeInfo model) {
        return codeInfoMapper.deleteByPrimaryKey(model.getCodeInfoId());
    }

    public int update(CodeInfo model) {
        return codeInfoMapper.updateByPrimaryKey(model);
    }

    public CodeInfo queryById(CodeInfo model) {
        return codeInfoMapper.selectByPrimaryKey(model.getCodeInfoId());
    }

    public List<CodeInfo> query() {
        return codeInfoMapper.selectByExample(null);
    }

    public List<CodeInfo> query(CodeInfo model) {
        CodeInfoExample example = new CodeInfoExample();
        if(model.getCodeTypeId() != null) {
            example.createCriteria().andCodeTypeIdEqualTo(model.getCodeTypeId());
        }
        if(model.getCodeTypeId() != null) {
            example.createCriteria().andCodeTypeIdEqualTo(model.getCodeTypeId());
        }
        return codeInfoMapper.selectByExample(example);
    }

    public PageInfo query(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return new PageInfo(codeInfoMapper.selectByExample(null));
    }
}
