package com.project.StudentManagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer schoolId;
    private String schoolName;

    @OneToMany(
            mappedBy = "school"
    )
    @JsonManagedReference
    private List<Student> students;

}