package com.iotProject.iot.Repositories;

import com.iotProject.iot.models.CapteurData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CapteurDataRepo extends JpaRepository<CapteurData, Long> {
    List<CapteurData> findAllByOrderByDateTime();
}
