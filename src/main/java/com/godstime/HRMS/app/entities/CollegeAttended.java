package com.godstime.HRMS.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "institutions_attended")
public class CollegeAttended {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "institution_graduation_date")
    private Date graduationDate;
}
