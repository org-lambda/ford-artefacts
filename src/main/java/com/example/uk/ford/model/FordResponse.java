package com.example.uk.ford.model;

import java.util.List;

public class FordResponse {

    Student student;

    List<Student> studentDetails;

    String successMsg;

    String errorMsg;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(List<Student> studentDetails) {
        this.studentDetails = studentDetails;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
