package com.project.StudentManagement.controller;

import com.project.StudentManagement.dao.SchoolDao;
import com.project.StudentManagement.dto.SchoolDto;
import com.project.StudentManagement.entity.School;
import com.project.StudentManagement.transformer.SchoolTransformer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.StudentManagement.common.ApiPath.*;

@RestController
@RequestMapping(SCHOOL_BASE_API)
public class SchoolController {
    private  final SchoolDao schoolDao;
    private  final SchoolTransformer schoolTransformer;

    public SchoolController(SchoolDao schoolDao,SchoolTransformer schoolTransformer) {
        this.schoolDao = schoolDao;
        this.schoolTransformer = schoolTransformer;
    }

    @PostMapping(CREATE_SCHOOL)
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto){
        var school = schoolTransformer.schoolDtoToSchool(schoolDto);
        var savedSchool =  schoolDao.save(school);
        return schoolDto;
    }

    @GetMapping(GET_SCHOOLS)
    public List<SchoolDto> getAllSchool() {
        return schoolDao.findAll()
                .stream()
                .map(schoolTransformer::schoolToSchoolDto)
                .toList(); // .collect(Collectors.toList())

    }

    @GetMapping(GET_SCHOOL)
    public School getSchoolbyId(@PathVariable("id") Integer id){
        return schoolDao.findById(id).orElse(null);
    }

    @DeleteMapping(DELETE_SCHOOL)
    @ResponseStatus(HttpStatus.OK)
    public void deleteSchoolById(@PathVariable Integer id){
        schoolDao.deleteById(id);
    }
}
