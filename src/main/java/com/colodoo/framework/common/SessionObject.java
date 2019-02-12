package com.colodoo.framework.common;

import com.colodoo.framework.manager.roleUser.model.RoleUser;
import com.colodoo.framework.manager.user.model.User;

import java.util.List;

/**
 * @author colodoo
 * @date 2018/10/18 15:55
 * @description
 */
public class SessionObject {
    private User user;
    private List<RoleUser> roleUsers;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RoleUser> getRoleUsers() {
        return roleUsers;
    }

    public void setRoleUsers(List<RoleUser> roleUsers) {
        this.roleUsers = roleUsers;
    }
}
