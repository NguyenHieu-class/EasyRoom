package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.RequestWithdrawal;
import com.project.EasyRoom.repository.RequestWithdrawalRepository;

@Service
public class RequestWithdrawalServiceImpl implements RequestWithdrawalService {

    @Autowired
    private RequestWithdrawalRepository repository;

    @Override
    public void saveRequestWithdrawal(RequestWithdrawal entity) {
        repository.save(entity);
    }

    @Override
    public void deleteRequestWithdrawalById(int id) {
        repository.deleteById(id);
    }

    @Override
    public RequestWithdrawal getRequestWithdrawalById(int id) {
        Optional<RequestWithdrawal> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<RequestWithdrawal> getAllRequestWithdrawals() {
        return repository.findAll();
    }

    @Override
    public long countRequestWithdrawals() {
        return repository.count();
    }
}
