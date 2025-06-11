package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.PaymentBill;

public interface PaymentBillService {

    void savePaymentBill(PaymentBill entity);
    void deletePaymentBillById(int id);
    PaymentBill getPaymentBillById(int id);
    List<PaymentBill> getAllPaymentBills();
    long countPaymentBills();
}
