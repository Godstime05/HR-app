package com.godstime.HRMS.app.services.impl;

import com.godstime.HRMS.app.entities.Department;
import com.godstime.HRMS.app.exceptions.DepartmentNotFoundException;
import com.godstime.HRMS.app.repository.DepartmentRepository;
import com.godstime.HRMS.app.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentalServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;


    @Autowired
    public DepartmentalServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public Department createDepartment(Department department) {
        if(department.getId() != null){
            throw new IllegalArgumentException("A new department should not have an ID.");
        }
        return departmentRepository.save(department);
        // return null;
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        if(id == null){
            throw new IllegalArgumentException("A department ID must be present when updating a department.");
        }
        if(!departmentRepository.existsById(id)){
            throw new DepartmentNotFoundException("Department with ID "+id+" not found.");
        }
        department.setId(id);
        return departmentRepository.save(department);
        // return null;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }


    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    @Override
    public Department findByName(String name) {
        Department department = departmentRepository.findByName(name);
        if (department == null) {
            throw new DepartmentNotFoundException(name);
        }
        return department;
    }


    @Override
    public Department getDepartmentById(Long id) {

        if(id == null){
            throw new IllegalArgumentException("A department ID must be present when fetching a department.");
        }
        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department with ID "+id+" not found.");
        }
        return department.get();
        //  return null;
    }

//    @Override
//    public List<Department> findByManagerId(Long managerId) {
//        List<Department> departments = departmentRepository..findByManagerId(managerId);
//        if (departments.isEmpty()) {
//            throw new DepartmentNotFoundException(managerId);
//        }
//        return departments;
//    }

    @Override
    public Department findByLocation(String location) {
        Department department = departmentRepository.findByLocation(location);
        if (department == null) {
            throw new DepartmentNotFoundException(location);
        }
        return department;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }


    @Override
    public void deleteDepartment(Long id) {

        if(id == null){
            throw new IllegalArgumentException("A department ID must be present when deleting a department.");
        }
        if(!departmentRepository.existsById(id)){
            throw new DepartmentNotFoundException("Department with ID "+id+" not found.");
        }
        departmentRepository.deleteById(id);

    }

}
/////