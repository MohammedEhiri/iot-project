package com.iotProject.iot.controllers;

import com.iotProject.iot.Repositories.CapteurDataRepo;
import com.iotProject.iot.Services.TemperatureService;
import com.iotProject.iot.models.CapteurData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestApi {

    @Autowired
    private CapteurDataRepo capteurDataRepo;
    private TemperatureService temperatureService;

    @GetMapping
    public List<CapteurData> getAllTemperatures() {
        return temperatureService.getAllTemperatures();
    }


}
