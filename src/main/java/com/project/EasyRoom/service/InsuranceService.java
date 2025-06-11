package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.Insurance;

public interface InsuranceService {

    void saveInsurance(Insurance entity);
    void deleteInsuranceById(int id);
    Insurance getInsuranceById(int id);
    List<Insurance> getAllInsurances();
    long countInsurances();
}
