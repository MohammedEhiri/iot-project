package com.iotProject.iot.Services;

import com.iotProject.iot.Repositories.CapteurDataRepo;
import com.iotProject.iot.models.CapteurData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {

    @Autowired
    private CapteurDataRepo capteurDataRepository;

    // Méthode pour récupérer la température actuelle à partir des données du capteur
    public double getCurrentTemperature() {
        // Récupérer la dernière entrée de données du capteur
        List<CapteurData> capteurDataList = capteurDataRepository.findAllByOrderByDateTime();
        if (!capteurDataList.isEmpty()) {
            return capteurDataList.get(0).getTemperature();
        } else {
            // Si aucune donnée n'est disponible, renvoyer une valeur par défaut
            return -1; // Valeur par défaut, à gérer en conséquence
        }
    }
}
