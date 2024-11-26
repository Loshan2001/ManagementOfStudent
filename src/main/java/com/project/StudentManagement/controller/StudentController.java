package com.project.StudentManagement.controller;

import  static  com.project.StudentManagement.common.ApiPath.*;
import com.project.StudentManagement.dao.StudentDao;
import com.project.StudentManagement.dto.StudentDto;
import com.project.StudentManagement.dto.StudentResponseDto;
import com.project.StudentManagement.entity.Student;
import com.project.StudentManagement.transformer.StudentTransformer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(STUDENT_BASE_API)
public class StudentController {
    private final StudentDao studentDao;
    private final StudentTransformer studentTransformer;

//    we use constructor injection so we don't want to use @Autowired
    public StudentController(StudentDao studentDao, StudentTransformer studentTransformer){
        this.studentDao = studentDao;
        this.studentTransformer = studentTransformer;
    }


    @PostMapping(CREATE_STUDENT)
    public StudentResponseDto createStudent(@RequestBody StudentDto studentDto){
        var student = studentTransformer.studentDtoToStudent(studentDto);
        var savedStudent = studentDao.save(student);
        return studentTransformer.studentToStudentResponseDto(savedStudent) ;

    }

    @GetMapping(GET_STUDENTS)
    public List<Student> getAllStudent(){
        return studentDao.findAll();
    }

    @GetMapping(GET_STUDENT)
    public Student getStudentById(@PathVariable("id") Integer id){
        return studentDao.findById(id).orElse(null);
    }

    @GetMapping(SEARCH_STUDENT_BY_NAME)
    public List<Student> getStudentByName(@PathVariable("studentName") String name){
        return studentDao.findAllByFirstNameContaining(name);
    }

    @DeleteMapping(DELETE_STUDENT)
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("id") Integer id){
        studentDao.deleteById(id);

    }

}
