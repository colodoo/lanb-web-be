package com.colodoo.framework.base.imp;

import com.colodoo.framework.easyui.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BaseServiceImp<T> {

    int save(T model);

    int delete(T model);

    int update(T model);

    T queryById(T model);

    List<T> query();

    PageInfo query(Page page);

}
