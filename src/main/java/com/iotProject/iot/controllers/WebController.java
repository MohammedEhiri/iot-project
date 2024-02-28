package com.iotProject.iot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String showTemperatureChart() {
        return "affichage"; // renvoie le nom de la vue Thymeleaf
    }
}
