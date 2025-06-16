package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.Ward;

public interface WardService {

    List<Ward> getAllWardWithDistrictWithProvinces();
	List<Ward> getAllWardWithDistrict();
	List<Ward> getAllWard();
	Ward getAWard(int id);
	void saveWard(Ward ward);
	void deleteWard(int id);
	List<Ward> getAllWardByIdDistric(int idDistrict);
}
