package com.godstime.HRMS.app.services;

import com.godstime.HRMS.app.entities.Employee;
import com.godstime.HRMS.app.exceptions.DepartmentNotFoundException;
import com.godstime.HRMS.app.exceptions.EmployeeNotFoundException;
import com.godstime.HRMS.app.exceptions.PositionNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee) throws DepartmentNotFoundException, PositionNotFoundException;

    Employee updateEmployee(Long id, Employee employee) throws EmployeeNotFoundException, DepartmentNotFoundException, PositionNotFoundException;

    boolean deleteEmployee(Long id) throws EmployeeNotFoundException;

    Employee findById(Long id);
    List<Employee> findAll();
    List<Employee> findByDepartment(Long departmentId);
    List<Employee> findByPosition(Long positionId);
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByPositionId(Long positionId);
    List<Employee> findBySalary(double salary);
    List<Employee> findByHireDate(LocalDate hireDate);
  //  List<Employee> findByHireDateBefore(LocalDate hireDate);
  //  List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);
    List<Employee> findByTerminatedDate(boolean terminatedDate);
    List<Employee> findByEmail(String email);
    List<Employee> findByPhoneNumber(String phoneNumber);
    Employee save(Employee employee);
    Employee getEmployee(Long employeeId);
    void deleteById(Long id);
}
//