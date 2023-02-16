package com.godstime.HRMS.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobs", "job_seekers", "work_experience"})
@Table(name = "job_positions")
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="position_name")
    private String position_name;

    @OneToMany(mappedBy = "jobPosition")
    @JsonIgnore
    private List<Job> jobs;

    @OneToMany(mappedBy = "jobPosition")
    @JsonIgnore
    private List<WorkExperience> workExperiences;
}
