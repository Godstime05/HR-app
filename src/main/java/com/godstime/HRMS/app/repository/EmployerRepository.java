package com.godstime.HRMS.app.repository;

import com.godstime.HRMS.app.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    Employer getEmployerById(int id);
}
