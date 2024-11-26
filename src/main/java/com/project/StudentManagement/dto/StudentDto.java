package com.project.StudentManagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotBlank
        @NotEmpty(message = "firstName should not be empty")
        String firstName,
        @NotBlank
        @NotEmpty(message = "lastName should not be empty")
        String lastName,
        String email,
        Integer age,
        Integer schoolId
) {

}
