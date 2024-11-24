package com.project.StudentManagement.controller;

import  static  com.project.StudentManagement.common.ApiPath.*;
import com.project.StudentManagement.dao.StudentDao;
import com.project.StudentManagement.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
