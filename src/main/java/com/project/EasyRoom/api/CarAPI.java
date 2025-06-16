package com.project.EasyRoom.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.EasyRoom.model.Car;
import com.project.EasyRoom.service.BrandCarService;
import com.project.EasyRoom.service.CarService;
import com.project.EasyRoom.service.ProvinceService;
import com.project.EasyRoom.service.UploadFile;
import com.project.EasyRoom.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/car")
public class CarAPI {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private BrandCarService brandCarService;

    @Autowired
    private UserService userService;

    @Autowired
    private UploadFile uploadFile;

    @Autowired
    private CarService carService;

    @GetMapping("")
    public List<Car> getCarByAdrress(){
       return null;
    }
}
