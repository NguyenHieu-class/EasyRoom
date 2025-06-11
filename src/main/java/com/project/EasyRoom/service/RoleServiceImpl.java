package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.Role;
import com.project.EasyRoom.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public void saveRole(Role entity) {
        repository.save(entity);
    }

    @Override
    public void deleteRoleById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Role getRoleById(int id) {
        Optional<Role> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    @Override
    public long countRoles() {
        return repository.count();
    }
}
