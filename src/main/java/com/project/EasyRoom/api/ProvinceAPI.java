package com.project.EasyRoom.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.EasyRoom.model.Province;
import com.project.EasyRoom.service.ProvinceService;

@CrossOrigin("*")
@RequestMapping("/api/province")
@RestController
public class ProvinceAPI {
	
	@Autowired
	private ProvinceService provinceService;

	@GetMapping("")
	public List<Province> getAllProvinceOrderByName(){
		return  provinceService.getAllProvinceOrderByName();
	}
}
