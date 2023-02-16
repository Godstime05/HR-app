package com.godstime.HRMS.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "institution","departments" })
@Table(name = "institutions")
public class Institution {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Department.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Department> departments;

    @JsonIgnore
    @OneToMany(mappedBy = "institution")
    private List<CollegeAttended> collegeAttended;

    @Column(name = "institution_name")
    private String institutionName;
}
