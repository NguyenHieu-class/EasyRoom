package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.Ward;
import com.project.EasyRoom.repository.WardRepository;

@Service
public class WardServiceImpl implements WardService {

    @Autowired
    private WardRepository repository;

    @Override
    public void saveWard(Ward entity) {
        repository.save(entity);
    }

    @Override
    public void deleteWardById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Ward getWardById(int id) {
        Optional<Ward> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Ward> getAllWards() {
        return repository.findAll();
    }

    @Override
    public long countWards() {
        return repository.count();
    }
}
