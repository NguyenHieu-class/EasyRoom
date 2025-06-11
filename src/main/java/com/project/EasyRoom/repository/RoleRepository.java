package com.project.EasyRoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer>{

	long count();
}