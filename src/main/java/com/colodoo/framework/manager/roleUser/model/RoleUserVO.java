package com.colodoo.framework.manager.roleUser.model;

/**
 * @author colodoo
 * @date 2018/8/30 15:34
 * @description
 */
public class RoleUserVO extends RoleUser {

    //角色名
    private String roleName;
    //用户名
    private String userName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
