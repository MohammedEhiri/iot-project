package com.iotProject.iot.controllers;

import com.iotProject.iot.Repositories.CapteurDataRepo;
import com.iotProject.iot.Services.TemperatureService;
import com.iotProject.iot.models.CapteurData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RestApi {

    @Autowired
    private CapteurDataRepo capteurDataRepo;
    private TemperatureService temperatureService;

    @GetMapping
    public List<CapteurData> getAllTemperatures() {
        return temperatureService.getAllTemperatures();
    }

    @GetMapping("/temperatures")
    public String showTemperatureList(Model model) {
        List<CapteurData> temperatures = temperatureService.getAllTemperatures();
        model.addAttribute("temperatures", temperatures);
        return "affichage";
    }


}
