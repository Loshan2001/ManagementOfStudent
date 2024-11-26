package com.project.StudentManagement.common;

public interface ApiPath {
    String STUDENT_BASE_API = "/api/student";
    String CREATE_STUDENT= "/create";
    String GET_STUDENTS="/getAllStudents";
    String GET_STUDENT= "/getStudent/{id}";
    String SEARCH_STUDENT_BY_NAME = "/search/{studentName}";
    String DELETE_STUDENT = "/delete/{id}";

    String SCHOOL_BASE_API = "/api/school";
    String CREATE_SCHOOL = "/create";
    String GET_SCHOOLS="/getAllSchool";
    String GET_SCHOOL= "/getSchool/{id}";
    String DELETE_SCHOOL = "/delete/{id}";

}
