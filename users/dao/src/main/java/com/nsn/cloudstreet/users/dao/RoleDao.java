package com.nsn.cloudstreet.users.dao;


import com.nsn.cloudstreet.common.GenericDao;
import com.nsn.cloudstreet.users.model.Role;

/**
 * Role Data Access Object (DAO) interface.
 */
public interface RoleDao extends GenericDao<Role, Long> {
    /**
     * Gets role information based on rolename
     * @param rolename the rolename
     * @return populated role object
     */
    Role getRoleByName(String rolename);

    /**
     * Removes a role from the database by name
     * @param rolename the role's rolename
     */
    void removeRole(String rolename);
}
