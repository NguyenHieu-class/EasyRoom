package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.PolicyAndTerms;
import com.project.EasyRoom.repository.PolicyAndTermsRepository;

@Service
public class PolicyAndTermsServiceImpl implements PolicyAndTermsService {

    @Autowired
    private PolicyAndTermsRepository repository;

    @Override
    public void savePolicyAndTerms(PolicyAndTerms entity) {
        repository.save(entity);
    }

    @Override
    public void deletePolicyAndTermsById(int id) {
        repository.deleteById(id);
    }

    @Override
    public PolicyAndTerms getPolicyAndTermsById(int id) {
        Optional<PolicyAndTerms> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<PolicyAndTerms> getAllPolicyAndTermss() {
        return repository.findAll();
    }

    @Override
    public long countPolicyAndTermss() {
        return repository.count();
    }
}
