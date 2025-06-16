package com.project.EasyRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.EasyRoom.model.PolicyAndTerms;
import com.project.EasyRoom.service.PolicyAndTermsService;

@RestController
@RequestMapping("/api")
public class PolicyAndTermsController {

    @Autowired
    private PolicyAndTermsService policyAndTermsService;

    @GetMapping("/policy-terms")
    public List<PolicyAndTerms> getAll() {
        return policyAndTermsService.getAllPolicyAndTermss();
    }

    @GetMapping("/policy-terms/{id}")
    public ResponseEntity<PolicyAndTerms> getById(@PathVariable int id) {
        PolicyAndTerms policy = policyAndTermsService.getPolicyAndTermsById(id);
        if (policy != null) {
            return ResponseEntity.ok(policy);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/policy-terms")
    public PolicyAndTerms create(@RequestBody PolicyAndTerms policy) {
        policyAndTermsService.savePolicyAndTerms(policy);
        return policy;
    }

    @PutMapping("/policy-terms/{id}")
    public ResponseEntity<PolicyAndTerms> update(@PathVariable int id, @RequestBody PolicyAndTerms policy) {
        PolicyAndTerms existing = policyAndTermsService.getPolicyAndTermsById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        policy.setIdPolicy(id);
        policyAndTermsService.savePolicyAndTerms(policy);
        return ResponseEntity.ok(policy);
    }

    @DeleteMapping("/policy-terms/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        policyAndTermsService.deletePolicyAndTermsById(id);
        return ResponseEntity.noContent().build();
    }
}
