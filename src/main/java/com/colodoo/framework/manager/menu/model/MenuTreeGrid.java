package com.colodoo.framework.manager.menu.model;

import java.io.Serializable;
import java.util.List;

public class MenuTreeGrid extends Menu implements Serializable {

    private String _parentId;

    public String get_parentId() {
        return _parentId;
    }

    public void set_parentId(String _parentId) {
        this._parentId = _parentId;
    }

    private String state;
    List<MenuTreeGrid> children;


    public List<MenuTreeGrid> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTreeGrid> children) {
        this.children = children;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}