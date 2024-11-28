package com.project.StudentManagement.service;

import com.project.StudentManagement.dao.StudentDao;
import com.project.StudentManagement.dto.StudentDto;
import com.project.StudentManagement.dto.StudentResponseDto;
import com.project.StudentManagement.entity.Student;
import com.project.StudentManagement.transformer.StudentTransformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    //which service we want to test
    @InjectMocks
    private StudentService studentService;

    //declare the dependencies
    @Mock
    private StudentTransformer studentTransformer;
    @Mock
    private StudentDao studentDao;




    // we need to tell mockito to start/mock the mock
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }
    @Test
    public void should_successfully_save_a_student(){
    //Given
        StudentDto studentDto = new StudentDto("loshan","saravanaperumal","loshan@gmail.com",23,1);
        Student student = new Student(1,"loshan", "saravanaperumal", "loshan@gmail.com", 23,null,null);
        Student savedStudent = new Student(1,"loshan", "saravanaperumal", "loshan@gmail.com", 23,null,null);
    //Mock the calls
        Mockito.when(studentTransformer.studentDtoToStudent(studentDto)).thenReturn(student);
        Mockito.when(studentDao.save(student)).thenReturn(savedStudent);
        Mockito.when(studentTransformer.studentToStudentResponseDto(savedStudent)).thenReturn(new StudentResponseDto("loshan","saravanaperumal",23,"loshan@gmail.com"));

    //When
        StudentResponseDto responseDto = studentService.createStudent(studentDto);
    //Then
        assertEquals(studentDto.firstName(),responseDto.firstName());
        assertEquals(studentDto.lastName(),responseDto.lastName());
        assertEquals(studentDto.age(),responseDto.age());
        assertEquals(studentDto.email(),responseDto.email());

        Mockito.verify(studentTransformer,Mockito.times(1)).studentDtoToStudent(studentDto);
        Mockito.verify(studentDao,Mockito.times(1)).save(student);
        Mockito.verify(studentTransformer,Mockito.times(1)).studentToStudentResponseDto(savedStudent);
    }

    @Test
    public void should_return_AllStudent(){
    //Given
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1,"loshan", "saravanaperumal", "loshan@gmail.com", 23,null,null));
    //Mock the calls
        Mockito.when(studentDao.findAll()).thenReturn(students);
        Mockito.when(studentTransformer.studentToStudentResponseDto(Mockito.any(Student.class))).thenReturn(new StudentResponseDto("loshan","saravanaperumal",23,"loshan@gmail.com"));


    //when
    List<StudentResponseDto> responseDtos = studentService.getAllStudent();

    //then
    assertEquals(students.size(),responseDtos.size());

    Mockito.verify(studentDao,Mockito.times(1));

    }


}