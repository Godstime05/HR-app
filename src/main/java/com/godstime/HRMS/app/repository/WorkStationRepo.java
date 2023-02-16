package com.godstime.HRMS.app.repository;

import com.godstime.HRMS.app.entities.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkStationRepo extends JpaRepository<WorkStation, Integer> {
    WorkStation getById(int id);

}
