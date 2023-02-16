package com.godstime.HRMS.app.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.godstime.HRMS.app.entities.JobSeeker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "job_seeker_id", referencedColumnName = "id")
    @JsonIgnore
    private JobSeeker jobSeeker;

    @Column(name = "image_title")
    private String imageTitle;

    @Column(name = "image")
    private String imagePath;

}
