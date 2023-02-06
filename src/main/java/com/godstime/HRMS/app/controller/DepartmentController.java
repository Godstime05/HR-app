package com.godstime.HRMS.app.controller;


import com.godstime.HRMS.app.entities.Department;
import com.godstime.HRMS.app.exceptions.DepartmentNotFoundException;
import com.godstime.HRMS.app.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/createDept")
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department) {
        return new ResponseEntity<>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
        } catch (DepartmentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @Valid @RequestBody Department department) {
        try {
            return new ResponseEntity<>(departmentService.updateDepartment(id, department), HttpStatus.OK);
        } catch (DepartmentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable Long id) {
        try {
            departmentService.deleteDepartment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DepartmentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
