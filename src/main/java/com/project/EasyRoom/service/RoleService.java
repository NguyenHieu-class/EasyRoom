package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.Role;

public interface RoleService {

    void saveRole(Role entity);
    void deleteRoleById(int id);
    Role getRoleById(int id);
    List<Role> getAllRoles();
    long countRoles();
}
