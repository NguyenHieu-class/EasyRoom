package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.Province;
import com.project.EasyRoom.repository.ProvinceRepository;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository repository;

    @Override
    public void saveProvince(Province entity) {
        repository.save(entity);
    }

    @Override
    public void deleteProvinceById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Province getProvinceById(int id) {
        Optional<Province> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Province> getAllProvinces() {
        return repository.findAll();
    }

    @Override
    public long countProvinces() {
        return repository.count();
    }
}
