package com.godstime.HRMS.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.godstime.HRMS.app.utils.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "job_seekers")
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLAzyInitializer", "handler"})
    private Users users;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "birth_date")
    private int birthDate;

    @Column(name = "nationality_id")
    private long nationalityId;

    @Column(name = "linkedin_account")
    private String linkedInAccount;

    @Column(name = "github_account")
    private String githubAccount;

    @Column(name = "info_about_job_seeker")
    private String info;

    @OneToMany(targetEntity = LangKnown.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "job_Seeker")
    private List<LangKnown> languages;

    @OneToMany(mappedBy = "jobSeeker",targetEntity = CollegeAttended.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CollegeAttended> collegeAttendedList;

    @OneToMany(mappedBy = "jobSeeker",targetEntity = Image.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> images;

    @OneToMany(mappedBy = "jobSeeker",targetEntity = WorkExperience.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkExperience> workExperiences;

}
