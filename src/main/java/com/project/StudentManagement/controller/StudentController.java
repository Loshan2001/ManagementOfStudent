package com.project.StudentManagement.controller;

import  static  com.project.StudentManagement.common.ApiPath.*;
import com.project.StudentManagement.dao.StudentDao;
import com.project.StudentManagement.dto.StudentDto;
import com.project.StudentManagement.dto.StudentResponseDto;
import com.project.StudentManagement.entity.Student;
import com.project.StudentManagement.service.StudentService;
import com.project.StudentManagement.transformer.StudentTransformer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(STUDENT_BASE_API)
public class StudentController {

    private final StudentService studentService;

//    we use constructor injection so we don't want to use @Autowired
    public StudentController( StudentService studentService){

        this.studentService = studentService;
    }


    @PostMapping(CREATE_STUDENT)
    public StudentResponseDto createStudent(@RequestBody StudentDto studentDto){
       return studentService.createStudent(studentDto);

    }


    @GetMapping(GET_STUDENTS)
    public List<StudentResponseDto> getAllStudent(){
        return studentService.getAllStudent();
    }


    @GetMapping(GET_STUDENT)
    public StudentResponseDto getStudentById(@PathVariable("id") Integer id){
        return studentService.getStudentById(id);
    }


    @GetMapping(SEARCH_STUDENT_BY_NAME)
    public List<StudentResponseDto> getStudentByName(@PathVariable("studentName") String name){
        return studentService.getStudentByName(name);
    }


    @DeleteMapping(DELETE_STUDENT)
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("id") Integer id){
        studentService.deleteStudent(id);
    }

}
