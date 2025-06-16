package com.project.EasyRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.EasyRoom.model.Contract;
import com.project.EasyRoom.service.ContractService;

@RestController
@RequestMapping("/api")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping("/contracts")
    public List<Contract> getAll() {
        return contractService.getAllContract();
    }

    @GetMapping("/contracts/{id}")
    public ResponseEntity<Contract> getById(@PathVariable int id) {
        Contract contract = contractService.getContractById(id);
        if (contract != null) {
            return ResponseEntity.ok(contract);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/contracts")
    public Contract create(@RequestBody Contract contract) {
        contractService.saveContract(contract);
        return contract;
    }

    @PutMapping("/contracts/{id}")
    public ResponseEntity<Contract> update(@PathVariable int id, @RequestBody Contract contract) {
        Contract existing = contractService.getContractById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        contract.setIdContract(id);
        contractService.saveContract(contract);
        return ResponseEntity.ok(contract);
    }

    @DeleteMapping("/contracts/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        contractService.deleteContract(id);
        return ResponseEntity.noContent().build();
    }
}
