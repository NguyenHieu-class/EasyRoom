package com.project.EasyRoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.PaymentBill;

@Repository
public interface PaymentBillRepository extends JpaRepository<PaymentBill, Integer> {

}
