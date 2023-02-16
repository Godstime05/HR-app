package com.godstime.HRMS.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "job")
public class Job {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "min_salary")
    private int minimumSalary;

    @Column(name = "max_salary")
    private int maximumSalary;

    @Column(name = "number_of_empty_positions")
    private int empty_positions;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne()
    @JoinColumn(name = "general_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "work_place_id")
    private WorkStation workStation;

    @ManyToOne()
    @JoinColumn(name = "work_time_id")
    private WorkTime workTime;
}
