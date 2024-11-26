package com.project.StudentManagement.controller;

import com.project.StudentManagement.dao.SchoolDao;
import com.project.StudentManagement.dto.SchoolDto;
import com.project.StudentManagement.entity.School;
import com.project.StudentManagement.service.SchoolService;
import com.project.StudentManagement.transformer.SchoolTransformer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.StudentManagement.common.ApiPath.*;

@RestController
@RequestMapping(SCHOOL_BASE_API)
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping(CREATE_SCHOOL)
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto){
        return schoolService.createSchool(schoolDto);
    }

    @GetMapping(GET_SCHOOLS)
    public List<SchoolDto> getAllSchool() {
        return schoolService.getAllSchool();// .collect(Collectors.toList())
    }

    @GetMapping(GET_SCHOOL)
    public SchoolDto getSchoolbyId(@PathVariable("id") Integer id){
        return schoolService.getSchoolbyId(id);
    }

    @DeleteMapping(DELETE_SCHOOL)
    @ResponseStatus(HttpStatus.OK)
    public void deleteSchoolById(@PathVariable Integer id){
        schoolService.deleteSchoolById(id);
    }
}
