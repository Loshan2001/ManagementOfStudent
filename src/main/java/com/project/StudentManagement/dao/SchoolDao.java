package com.project.StudentManagement.dao;

import com.project.StudentManagement.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDao extends JpaRepository<School,Integer> {
}
