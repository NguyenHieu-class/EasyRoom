package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.Province;

public interface ProvinceService {

    List<Province> getAllProvinceOrderByName();
	void saveProvices(Province p);
	Province getProvince(int id);
	void deleteProvince(int id);
    
}
