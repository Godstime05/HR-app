package com.godstime.HRMS.app.repository;


import com.godstime.HRMS.app.entities.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobPositionRepo extends JpaRepository<JobPosition, Integer> {

    JobPosition getJobPositionById(int id);

}
