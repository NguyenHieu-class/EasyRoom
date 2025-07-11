package com.project.EasyRoom.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.EasyRoom.model.Insurance;
import com.project.EasyRoom.service.InsuranceService;
import com.project.EasyRoom.service.UploadFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/insurance")
public class InsuranceAPI {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private UploadFile uploadFile;

    @GetMapping("")
    public List<Insurance> showAll() {
        return insuranceService.getAllInsurance();
    }

}
