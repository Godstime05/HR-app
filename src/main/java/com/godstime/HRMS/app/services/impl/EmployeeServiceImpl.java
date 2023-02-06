package com.godstime.HRMS.app.services.impl;

import com.godstime.HRMS.app.entities.Department;
import com.godstime.HRMS.app.entities.Employee;
import com.godstime.HRMS.app.exceptions.DepartmentNotFoundException;
import com.godstime.HRMS.app.exceptions.EmployeeNotFoundException;
import com.godstime.HRMS.app.exceptions.PositionNotFoundException;
import com.godstime.HRMS.app.repository.EmployeeRepository;
import com.godstime.HRMS.app.services.DepartmentService;
import com.godstime.HRMS.app.services.EmployeeService;
import com.godstime.HRMS.app.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final PositionService positionService;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionService positionService, DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.positionService = positionService;
        this.departmentService = departmentService;
    }

    @Override
    public Employee createEmployee(Employee employee) throws DepartmentNotFoundException, PositionNotFoundException {
        // check if department and position exists
        if (!departmentService.existsById(employee.getDepartment().getId())) {
            throw new DepartmentNotFoundException("Department with id " + employee.getDepartment().getId() + " not found");
        }
        if (!positionService.existsById(employee.getPosition().getId())) {
            throw new PositionNotFoundException("Position with id " + employee.getPosition().getId() + " not found");
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) throws EmployeeNotFoundException, DepartmentNotFoundException, PositionNotFoundException {
        if (!existsById(id)) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }

        // check if department and position exists
        if (!departmentService.existsById(employee.getDepartment().getId())) {
            throw new DepartmentNotFoundException("Department with id " + employee.getDepartment().getId() + " not found");
        }
        if (!positionService.existsById(employee.getPosition().getId())) {
            throw new PositionNotFoundException("Position with id " + employee.getPosition().getId() + " not found");
        }

        Employee existingEmployee = findById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setPosition(employee.getPosition());

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public boolean deleteEmployee(Long id) throws EmployeeNotFoundException {
        if (!existsById(id)) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        employeeRepository.deleteById(id);
        return false;
    }

    private boolean existsById(Long id) {
        return false;
    }


    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByDepartment(Long departmentId) {
        Department department = departmentService.findById(departmentId);
        return employeeRepository.findByDepartmentId(departmentId);

    }

    @Override
    public List<Employee> findByPosition(Long positionId) {

       // Position position = positionService.findById(positionId);
        return employeeRepository.findByPositionId(positionId);

    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
       // return null;
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    @Override
    public List<Employee> findByDepartmentId(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    @Override
    public List<Employee> findByPositionId(Long positionId) {
        return employeeRepository.findByPositionId(positionId);
    }

    @Override
    public List<Employee> findBySalary(double salary) {
        return employeeRepository.findBySalary(salary);
    }

    @Override
    public List<Employee> findByHireDate(LocalDate hireDate) {
        return employeeRepository.findByHireDate(hireDate);
    }

//    @Override
//    public List<Employee> findByHireDateBefore(LocalDate hireDate) {
//        return employeeRepository.findByHireDateBefore(hireDate);
//    }

//    @Override
//    public List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate) {
//        return employeeRepository.findByHireDateBetween(startDate, endDate);
//    }

    @Override
    public List<Employee> findByTerminatedDate(boolean terminated) {
        return employeeRepository.findByTerminatedDate(terminated);
    }

    @Override
    public List<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
           //     .orElseThrow(() -> new EmployeeNotFoundException("Employee with email "+email+" not found."));
    }


    @Override
    public List<Employee> findByPhoneNumber(String phoneNumber) {
        return employeeRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Employee save(Employee employee) {

        if(employee.getId() != null){
            throw new IllegalArgumentException("An employee ID should not be present when creating a new employee.");
        }
        if(employee.getDepartment() == null){
            throw new IllegalArgumentException("An employee must be associated with a department.");
        }
        if(employee.getPosition() == null){
            throw new IllegalArgumentException("An employee must have a position.");
        }
        return employeeRepository.save(employee);
    }


//    @Override
//    public Employee getEmployee(Long employee) {
//
//        if(employee.getId() == null){
//            throw new IllegalArgumentException("An employee ID must be present when updating an employee.");
//        }
//        if(employee.getDepartment() == null){
//            throw new IllegalArgumentException("An employee must be associated with a department.");
//        }
//        if(employee.getPosition() == null){
//            throw new IllegalArgumentException("An employee must have a position.");
//        }
//        if(!employeeRepository.existsById(employee.getId())){
//            throw new EmployeeNotFoundException("Employee with ID "+employee.getId()+" not found.");
//        }
//        return employeeRepository.save(employee);
//
//    }

    @Override
    public Employee getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID "+ employeeId+" not found."));
        if(employee.getDepartment() == null){
            throw new IllegalArgumentException("An employee must be associated with a department.");
        }
        if(employee.getPosition() == null){
            throw new IllegalArgumentException("An employee must have a position.");
        }
        return employee;
    }


    @Override
    public void deleteById(Long id) {
        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException("Employee with ID "+id+" not found.");
        }
        employeeRepository.deleteById(id);

    }

}

//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//
//    private final EmployeeRepository employeeRepository;
//
//    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
////
////    @Override
////    public Employee save(Employee employee) {
////        if(employee.getId() != null){
////            throw new IllegalArgumentException("An employee ID should not be present when creating a new employee.");
////        }
////        if(employee.getDepartment() == null){
////            throw new IllegalArgumentException("An employee must be associated with a department.");
////        }
////        if(employee.getPosition() == null){
////            throw new IllegalArgumentException("An employee must have a position.");
////        }
////        return employeeRepository.save(employee);
////    }
//
////    @Override
//////    public Employee update(Employee employee) {
//////        if(employee.getId() == null){
//////            throw new IllegalArgumentException("An employee ID must be present when updating an employee.");
//////        }
//////        if(employee.getDepartment() == null){
//////            throw new IllegalArgumentException("An employee must be associated with a department.");
//////        }
//////        if(employee.getPosition() == null){
//////            throw new IllegalArgumentException("An employee must have a position.");
//////        }
//////        if(!employeeRepository.existsById(employee.getId())){
//////            throw new EmployeeNotFoundException("Employee with ID "+employee.getId()+" not found.");
//////        }
//////        return employeeRepository.save(employee);
//////    }
////
////    @Override
////    public Employee findById(Long id) {
////        return employeeRepository.findById(id)
////                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID "+id+" not found."));
////    }
//
////    @Override
////    public List<Employee> findAll() {
////        return employeeRepository.findAll();
////    }
//
//    @Override
//    public void deleteById(Long id) {
//        if(!employeeRepository.existsById(id)){
//            throw new EmployeeNotFoundException("Employee with ID "+id+" not found.");
//        }
//        employeeRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Employee> findByDepartment(Department department) {
//        return employeeRepository.findByDepartment(department);
//    }
//
//    @Override
//    public List<Employee> findByPosition(Position position) {
//        return employeeRepository.findByPosition(position);
//    }
//
//    @Override
//    public List<Employee> findByName(String name) {
//        return employeeRepository.findByName(name);
//    }
//
//    @Override
//    public Employee findByEmail(String email) {
//        return employeeRepository.findByEmail(email)
//                .orElseThrow(() -> new EmployeeNotFoundException("Employee with email "+email+" not found."));
//    }
//}
//
