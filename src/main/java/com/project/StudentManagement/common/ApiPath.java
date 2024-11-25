package com.project.StudentManagement.common;

public interface ApiPath {
    String STUDENT_BASE_API = "/api/student";
    String CREATE_STUDENT= "/create";
    String GET_STUDENTS="/getAllStudents";
    String GET_STUDENT= "/getStudent/{id}";
    String SEARCH_STUDENT_BY_NAME = "/search/{studentName}";
    String DELETE_STUDENT = "/delete/{id}";
}
