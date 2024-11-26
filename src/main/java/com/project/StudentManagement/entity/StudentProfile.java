package com.project.StudentManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer studentProfileId;
    private String bio;
    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;


}
