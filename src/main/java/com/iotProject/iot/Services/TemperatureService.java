package com.iotProject.iot.Services;

import com.iotProject.iot.Repositories.CapteurDataRepo;
import com.iotProject.iot.models.CapteurData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {

    @Autowired
    private CapteurDataRepo capteurDataRepo;

    public List<CapteurData> getAllTemperatures() {
        return capteurDataRepo.findAll();
    }

    public CapteurData addTemperature(CapteurData temperature) {
        return capteurDataRepo.save(temperature);
    }
}
