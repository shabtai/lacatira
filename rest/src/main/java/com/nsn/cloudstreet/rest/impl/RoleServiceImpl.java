package com.nsn.cloudstreet.rest.impl;

import com.nsn.cloudstreet.rest.RoleService;
import com.nsn.cloudstreet.users.management.RoleManager;
import com.nsn.cloudstreet.users.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private RoleManager roleManager;

    public List<Role> getRoles() throws Exception {
        List<Role> roles;

        roles = roleManager.getAll();

        return roles;
    }

    public Role getRole(String name) {
        return roleManager.getRole(name);
    }

    public Role saveRole(Role role) throws Exception {

        return roleManager.saveRole(role);
    }

    @Autowired
    public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }
}