package com.godstime.HRMS.app.repository;

import com.godstime.HRMS.app.entities.Employer;
import com.godstime.HRMS.app.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {


    List<Job> getAllByIsActiveTrueAndEmployer_Id(int id);

    Employer getJobById(int id);

    @Modifying
    @Query("UPDATE Job SET isActive = false WHERE id=:id")
    void jobIsInactive(@Param("id") int id);

    @Modifying
    @Query("UPDATE Job SET isActive = true WHERE id=:id")
    void jobIsActive(@Param("id") int id);
}
