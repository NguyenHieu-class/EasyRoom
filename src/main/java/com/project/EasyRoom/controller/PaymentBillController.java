package com.project.EasyRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.EasyRoom.model.PaymentBill;
import com.project.EasyRoom.service.PaymentBillService;

@RestController
@RequestMapping("/api")
public class PaymentBillController {

    @Autowired
    private PaymentBillService paymentBillService;

    @GetMapping("/payment-bills")
    public List<PaymentBill> getAll() {
        return paymentBillService.getAllPaymentBills();
    }

    @GetMapping("/payment-bills/{id}")
    public ResponseEntity<PaymentBill> getById(@PathVariable int id) {
        PaymentBill bill = paymentBillService.getPaymentBillById(id);
        if (bill != null) {
            return ResponseEntity.ok(bill);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/payment-bills")
    public PaymentBill create(@RequestBody PaymentBill bill) {
        paymentBillService.savePaymentBill(bill);
        return bill;
    }

    @PutMapping("/payment-bills/{id}")
    public ResponseEntity<PaymentBill> update(@PathVariable int id, @RequestBody PaymentBill bill) {
        PaymentBill existing = paymentBillService.getPaymentBillById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        bill.setIdPayment(id);
        paymentBillService.savePaymentBill(bill);
        return ResponseEntity.ok(bill);
    }

    @DeleteMapping("/payment-bills/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        paymentBillService.deletePaymentBillById(id);
        return ResponseEntity.noContent().build();
    }
}
