package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.PaymentBill;
import com.project.EasyRoom.repository.PaymentBillRepository;

@Service
public class PaymentBillServiceImpl implements PaymentBillService {

    @Autowired
    private PaymentBillRepository repository;

    @Override
    public void savePaymentBill(PaymentBill entity) {
        repository.save(entity);
    }

    @Override
    public void deletePaymentBillById(int id) {
        repository.deleteById(id);
    }

    @Override
    public PaymentBill getPaymentBillById(int id) {
        Optional<PaymentBill> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<PaymentBill> getAllPaymentBills() {
        return repository.findAll();
    }

    @Override
    public long countPaymentBills() {
        return repository.count();
    }
}
