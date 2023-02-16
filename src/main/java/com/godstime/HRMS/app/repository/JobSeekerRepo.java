package com.godstime.HRMS.app.repository;

import com.godstime.HRMS.app.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobSeekerRepo extends JpaRepository<JobSeeker, Integer> {
    List<JobSeeker> findByNationalityId(long nationalityId);

    JobSeeker findById(int id);

    @Query("FROM JobSeeker i inner join i.work_experiences w order by w.start_date desc")
    List<JobSeeker> findByWorkExperiencesStartDate();
}
