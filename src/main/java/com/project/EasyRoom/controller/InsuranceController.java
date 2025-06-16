package com.project.EasyRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.EasyRoom.model.Insurance;
import com.project.EasyRoom.service.InsuranceService;

@RestController
@RequestMapping("/api")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping("/insurances")
    public List<Insurance> getAll() {
        return insuranceService.getAllInsurances();
    }

    @GetMapping("/insurances/{id}")
    public ResponseEntity<Insurance> getById(@PathVariable int id) {
        Insurance insurance = insuranceService.getInsuranceById(id);
        if (insurance != null) {
            return ResponseEntity.ok(insurance);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/insurances")
    public Insurance create(@RequestBody Insurance insurance) {
        insuranceService.saveInsurance(insurance);
        return insurance;
    }

    @PutMapping("/insurances/{id}")
    public ResponseEntity<Insurance> update(@PathVariable int id, @RequestBody Insurance insurance) {
        Insurance existing = insuranceService.getInsuranceById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        insurance.setIdInsurance(id);
        insuranceService.saveInsurance(insurance);
        return ResponseEntity.ok(insurance);
    }

    @DeleteMapping("/insurances/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        insuranceService.deleteInsuranceById(id);
        return ResponseEntity.noContent().build();
    }
}
