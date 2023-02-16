package com.godstime.HRMS.app.repository;

import com.godstime.HRMS.app.entities.WorkStation;
import com.godstime.HRMS.app.entities.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTimeRepo extends JpaRepository<WorkTime, Integer> {
    WorkTime getById(int id);

}
