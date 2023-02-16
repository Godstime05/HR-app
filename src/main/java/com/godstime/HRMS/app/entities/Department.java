package com.godstime.HRMS.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "department_name")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dept_name")
    private String deptName;
//
//    @Column(name = "location")
//    private String location;
//
//    @OneToMany(mappedBy = "department")
//    private List<Employee> employees;


//    public int countEmployees() {
//        return employees.size();
//    }
//
//    public double calculateTotalSalary() {
//        double total = 0;
//        for (Employee employee : employees) {
//            total += employee.getSalary();
//        }
//        return total;
//    }


}







