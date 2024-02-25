package com.iotProject.iot.Repositories;

import com.iotProject.iot.models.CapteurData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapteurDataRepo extends JpaRepository<CapteurData, Long> {
}
