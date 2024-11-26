package com.project.StudentManagement.service;

import com.project.StudentManagement.dao.SchoolDao;
import com.project.StudentManagement.dto.SchoolDto;
import com.project.StudentManagement.entity.School;
import com.project.StudentManagement.transformer.SchoolTransformer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SchoolService {
    private  final SchoolDao schoolDao;
    private  final SchoolTransformer schoolTransformer;

    public SchoolService(SchoolDao schoolDao,SchoolTransformer schoolTransformer) {
        this.schoolDao = schoolDao;
        this.schoolTransformer = schoolTransformer;
    }

    public SchoolDto createSchool(SchoolDto schoolDto){
        var school = schoolTransformer.schoolDtoToSchool(schoolDto);
        var savedSchool =  schoolDao.save(school);
        return schoolDto;
    }

    public List<SchoolDto> getAllSchool() {
        return schoolDao.findAll()
                .stream()
                .map(schoolTransformer::schoolToSchoolDto)
                .toList(); // .collect(Collectors.toList())

    }

    public SchoolDto getSchoolbyId(@PathVariable("id") Integer id){
        return schoolDao.findById(id)
                .map(schoolTransformer::schoolToSchoolDto)
                .orElse(null);
    }

    public void deleteSchoolById(@PathVariable Integer id){
        schoolDao.deleteById(id);
    }
}
