package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.Role;

public interface RoleService {

    List <Role> getAllRole();
	Role getRoleById(int id);
	void saveRole(Role role);
	boolean deteleRole(int id);
}
