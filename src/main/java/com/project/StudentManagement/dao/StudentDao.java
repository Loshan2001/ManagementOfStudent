package com.project.StudentManagement.dao;

import com.project.StudentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
    List<Student> findAllByFirstNameContaining(String firstName);
}
