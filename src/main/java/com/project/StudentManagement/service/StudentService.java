package com.project.StudentManagement.service;

import com.project.StudentManagement.dao.StudentDao;
import com.project.StudentManagement.dto.StudentDto;
import com.project.StudentManagement.dto.StudentResponseDto;
import com.project.StudentManagement.entity.Student;
import com.project.StudentManagement.transformer.StudentTransformer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService {

    private final StudentDao studentDao;
    private final StudentTransformer studentTransformer;


    public StudentService(StudentDao studentDao, StudentTransformer studentTransformer){
        this.studentTransformer=studentTransformer;
        this.studentDao =studentDao;
    }

    public StudentResponseDto createStudent(StudentDto studentDto){
        var student = studentTransformer.studentDtoToStudent(studentDto);
        var savedStudent = studentDao.save(student);
        return studentTransformer.studentToStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> getAllStudent(){
        return studentDao.findAll()
                .stream()
                .map(studentTransformer::studentToStudentResponseDto)
                .toList();
    }

    public StudentResponseDto getStudentById(Integer id){
        return studentDao.findById(id)
                .map(studentTransformer::studentToStudentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> getStudentByName(String name){
        return studentDao.findAllByFirstNameContaining(name)
                .stream()
                .map(studentTransformer::studentToStudentResponseDto)
                .toList();
    }

    public void deleteStudent(Integer id){
        studentDao.deleteById(id);

    }
}
