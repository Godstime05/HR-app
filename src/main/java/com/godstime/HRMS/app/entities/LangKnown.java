package com.godstime.HRMS.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lang_of_communication")
public class LangKnown {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "job_seeker_id", referencedColumnName = "id")
    @JsonIgnore
    private JobSeeker jobSeeker;

    @ManyToOne()
    @JoinColumn(name = "lang_level_id")
    private LangLevel langLevel;

    @Column(name = "lang_name")
    private String langName;
}
