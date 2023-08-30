package com.faceRecogAttendance.service;

import com.faceRecogAttendance.entity.Student;
import com.faceRecogAttendance.exception.StudentDetailsNotFound;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents() throws StudentDetailsNotFound;
    Student getStudentById(int rollNo) throws StudentDetailsNotFound;
    Student getStudentByName(String Name) throws StudentDetailsNotFound;
    Student saveStudent(Student student) throws StudentDetailsNotFound;
    Student updateStudent(Student student) throws StudentDetailsNotFound;
    void deleteStudentById(int rollNo) throws StudentDetailsNotFound;
}
