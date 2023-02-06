package com.godstime.HRMS.app.controller;


import com.godstime.HRMS.app.entities.Employee;
import com.godstime.HRMS.app.exceptions.EmployeeCreationFailedException;
import com.godstime.HRMS.app.exceptions.EmployeeDeletionFailedException;
import com.godstime.HRMS.app.exceptions.EmployeeNotFoundException;
import com.godstime.HRMS.app.exceptions.EmployeeUpdateFailedException;
import com.godstime.HRMS.app.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        if (createdEmployee == null) {
            throw new EmployeeCreationFailedException("Failed to create employee, please try again.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Long employeeId, @Valid @RequestBody Employee employee) throws EmployeeUpdateFailedException {
        Employee updatedEmployee = employeeService.updateEmployee(employeeId, employee);
        if (updatedEmployee == null) {
            throw new EmployeeUpdateFailedException("Failed to update employee, please try again.");
        }
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with id: " + employeeId + " not found.");
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAll(); //.getAllEmployees();
        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        boolean isDeleted = employeeService.deleteEmployee(employeeId);
        if (!isDeleted) {
            throw new EmployeeDeletionFailedException("Failed to delete employee, please try again.");
        }
        return ResponseEntity.ok("Employee with id: " + employeeId + " deleted successfully.");
    }

}

