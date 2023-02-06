package com.godstime.HRMS.app.services;

import com.godstime.HRMS.app.entities.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();
    Department findByName(String name);
   // List<Department> findByManagerId(Long managerId);
    Department findByLocation(String location);
   // Department findById(Long departmentId);

        Department findById(Long id);


    boolean existsById(Long id);

    Department updateDepartment(Long id, Department department);

    void deleteDepartment(Long id);

    Department createDepartment(Department department);

    Department getDepartmentById(Long id);
}
