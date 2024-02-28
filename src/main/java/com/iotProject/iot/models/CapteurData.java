package com.iotProject.iot.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@Entity
@Table(name = "Data")
public class CapteurData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double temperature;
    private double humidity;
    private LocalDateTime dateTime;

}
