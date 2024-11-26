package com.project.StudentManagement.transformer;

import com.project.StudentManagement.dto.SchoolDto;
import com.project.StudentManagement.entity.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolTransformer {
    public School schoolDtoToSchool(SchoolDto schoolDto){
        var school = new School();
        school.setSchoolName(schoolDto.schoolName());
        return school;
    }

    public SchoolDto schoolToSchoolDto(School school){
        return new SchoolDto(school.getSchoolName());
    }

}
