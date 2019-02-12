package com.colodoo.framework.base.imp;

import com.colodoo.framework.easyui.Page;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

public interface BaseActionImp<T> {

    @RequestMapping(value = "/save")
    Map save(T model);

    Map delete(T model);

    Map update(T model);

    Map queryById(T model);

    List<T> query();

    Map query(Page page);

}
