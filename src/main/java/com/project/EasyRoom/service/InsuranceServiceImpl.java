package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.Insurance;
import com.project.EasyRoom.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository repository;

    @Override
    public void saveInsurance(Insurance entity) {
        repository.save(entity);
    }

    @Override
    public void deleteInsuranceById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Insurance getInsuranceById(int id) {
        Optional<Insurance> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Insurance> getAllInsurances() {
        return repository.findAll();
    }

    @Override
    public long countInsurances() {
        return repository.count();
    }
}
