package com.project.StudentManagement.dto;

public record StudentResponseDto(
        String firstName,
        String lastName,
        Integer age,
        String email
) {
}
