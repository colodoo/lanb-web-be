package com.colodoo.framework.common;

import com.colodoo.framework.manager.roleUser.model.RoleUser;
import com.colodoo.framework.manager.user.model.User;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author colodoo
 * @date 2018/10/18 15:55
 * @description
 */
//@SessionScope
//@Component(value = "sessionObject")
public class SessionObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
