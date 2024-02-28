package com.iotProject.iot.controllers;

import com.iotProject.iot.Services.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TemperatureRestController {

    @Autowired
    private TemperatureService temperatureService;

    @GetMapping("/current-temperature")
    public double getCurrentTemperature() {
        return temperatureService.getCurrentTemperature();
    }

    @GetMapping("/last-humidity")
    public double getLastHumidity() {
        return temperatureService.getLastHumidity();
    }

    @GetMapping("/temperature-data")
    public List<List<Double>> getTemperatureData() {
        List<List<Double>> temperatureData = new ArrayList<>();
        List<Double> data = new ArrayList<>();
        data.add(this.getCurrentTemperature());
        data.add(this.getLastHumidity());
        temperatureData.add(data);
        return temperatureData;
    }
}