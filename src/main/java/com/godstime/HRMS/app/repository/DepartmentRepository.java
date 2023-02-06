package com.godstime.HRMS.app.repository;

import com.godstime.HRMS.app.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Custom query method to find department by name
    Department findByName(String name);

    // Custom query method to find all departments by manager id
   // List<Department> findByManagerId(Long managerId);

    // Custom query method to find department by location
    Department findByLocation(String location);

    // inherited findById method
    Optional<Department> findById(Long id);
}
