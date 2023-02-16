package com.godstime.HRMS.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "lang_levels")
public class LangLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "level_desc")
    private String levelDesc;

    @OneToMany(mappedBy = "langLevel")
    private List<LangKnown> commLanguages;
}
