package com.project.StudentManagement.transformer;

import com.project.StudentManagement.dto.StudentDto;
import com.project.StudentManagement.dto.StudentResponseDto;
import com.project.StudentManagement.entity.School;
import com.project.StudentManagement.entity.Student;
import org.springframework.stereotype.Service;


@Service
public class StudentTransformer {

    public Student studentDtoToStudent(StudentDto studentDto){
        var student= new Student();
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());
        student.setAge(studentDto.age());
        var school = new School();
        school.setSchoolId(studentDto.schoolId());
        student.setSchool(school);
        return student;
    }

    public StudentResponseDto studentToStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getEmail()
        );
    }



}
