package com.iotProject.iot.controllers;

import com.iotProject.iot.Services.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TemperatureRestController {

    @Autowired
    private TemperatureService temperatureService;

    @GetMapping("/current-temperature")
    public double getCurrentTemperature() {
        return temperatureService.getCurrentTemperature();
    }
}