package com.project.StudentManagement.controller;

import  static  com.project.StudentManagement.common.ApiPath.*;
import com.project.StudentManagement.dao.StudentDao;
import com.project.StudentManagement.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(STUDENT_BASE_API)
public class StudentController {
    private final StudentDao studentDao;

//    we use constructor injection so we don't want to use @Autowired
    public StudentController(StudentDao studentDao){
        this.studentDao = studentDao;

    }


    @PostMapping(CREATE_STUDENT)
    public Student createStudent(@RequestBody Student student){
        return studentDao.save(student);

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
