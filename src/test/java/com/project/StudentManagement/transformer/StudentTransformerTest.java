package com.project.StudentManagement.transformer;

import com.project.StudentManagement.dto.StudentDto;
import com.project.StudentManagement.dto.StudentResponseDto;
import com.project.StudentManagement.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTransformerTest {

    private StudentTransformer studentTransformer;

    @BeforeEach
    void setUp(){
        studentTransformer = new StudentTransformer();
    }

    @Test
    public void shouldMapStudentDtoToStudent(){
        StudentDto studentDto = new StudentDto("loshan","saravanaperumal","loshansp2001@gmail.com",23,1);
        Student student = studentTransformer.studentDtoToStudent(studentDto);
        assertEquals(studentDto.firstName(),student.getFirstName());
        assertEquals(studentDto.lastName(),student.getLastName());
        assertEquals(studentDto.email(),student.getEmail());
        assertEquals(studentDto.age(),student.getAge());
        assertNotNull(student.getSchool());
        assertEquals(studentDto.schoolId(),student.getSchool().getSchoolId());

    }

    @Test
    public void shouldMapStudentToStudentResponseDto(){
        //given
        Student student = new Student(1,"loshan", "saravanaperumal", "loshansp2001@gmail.com", 23,null,null);
        //when
        StudentResponseDto responseDto = studentTransformer.studentToStudentResponseDto(student);
        //then
        assertEquals(responseDto.firstName(), responseDto.firstName());
        assertEquals(responseDto.lastName(), responseDto.lastName());
        assertEquals(responseDto.age(), responseDto.age());
        assertEquals(responseDto.email(), responseDto.email());
    }

    @Test
    public void should_throw_Null_Pointer_Exception_when_StudentDto_is_null(){
        var exp =  assertThrows(NullPointerException.class,()-> studentTransformer.studentDtoToStudent(null));
        assertEquals("the StudentDto should not be Null",exp.getMessage());
    }


}