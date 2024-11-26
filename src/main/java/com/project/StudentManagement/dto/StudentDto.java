package com.project.StudentManagement.dto;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Integer age,
        Integer schoolId
) {

}
