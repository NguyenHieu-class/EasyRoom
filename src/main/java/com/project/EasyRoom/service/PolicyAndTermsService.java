package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.PolicyAndTerms;

public interface PolicyAndTermsService {

    void savePolicyAndTerms(PolicyAndTerms entity);
    void deletePolicyAndTermsById(int id);
    PolicyAndTerms getPolicyAndTermsById(int id);
    List<PolicyAndTerms> getAllPolicyAndTermss();
    long countPolicyAndTermss();
}
