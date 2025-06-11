package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.Province;

public interface ProvinceService {

    void saveProvince(Province entity);
    void deleteProvinceById(int id);
    Province getProvinceById(int id);
    List<Province> getAllProvinces();
    long countProvinces();
}
