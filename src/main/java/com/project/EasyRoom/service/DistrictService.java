package com.project.EasyRoom.service;

import java.util.List;

import com.project.EasyRoom.model.District;

public interface DistrictService {
	List<District> getAllDistricWithProvenice();
	void saveDistrict(District d);
	District getDistrict(int id);
	void deleteDistrict(int id);
	List<District> getAllDistrict();
	List<District> getAllDistrictByIdProvince(int idProvence);
	
}
