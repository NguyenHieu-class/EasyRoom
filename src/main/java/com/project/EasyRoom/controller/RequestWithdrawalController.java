package com.project.EasyRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.EasyRoom.model.RequestWithdrawal;
import com.project.EasyRoom.service.RequestWithdrawalService;

@RestController
@RequestMapping("/api")
public class RequestWithdrawalController {

    @Autowired
    private RequestWithdrawalService requestWithdrawalService;

    @GetMapping("/request-withdrawals")
    public List<RequestWithdrawal> getAll() {
        return requestWithdrawalService.getAllRequestWithdrawals();
    }

    @GetMapping("/request-withdrawals/{id}")
    public ResponseEntity<RequestWithdrawal> getById(@PathVariable int id) {
        RequestWithdrawal req = requestWithdrawalService.getRequestWithdrawalById(id);
        if (req != null) {
            return ResponseEntity.ok(req);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/request-withdrawals")
    public RequestWithdrawal create(@RequestBody RequestWithdrawal req) {
        requestWithdrawalService.saveRequestWithdrawal(req);
        return req;
    }

    @PutMapping("/request-withdrawals/{id}")
    public ResponseEntity<RequestWithdrawal> update(@PathVariable int id, @RequestBody RequestWithdrawal req) {
        RequestWithdrawal existing = requestWithdrawalService.getRequestWithdrawalById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        req.setIdRequest(id);
        requestWithdrawalService.saveRequestWithdrawal(req);
        return ResponseEntity.ok(req);
    }

    @DeleteMapping("/request-withdrawals/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        requestWithdrawalService.deleteRequestWithdrawalById(id);
        return ResponseEntity.noContent().build();
    }
}
