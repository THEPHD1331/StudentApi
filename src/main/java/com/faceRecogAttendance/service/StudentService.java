package com.faceRecogAttendance.service;

import com.faceRecogAttendance.entity.Student;
import com.faceRecogAttendance.exception.StudentDetailsNotFound;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

public interface StudentService {

    List<Student> getAllStudents() throws StudentDetailsNotFound;
    Student getStudentById(int rollNo) throws StudentDetailsNotFound;
    Student getStudentByName(String Name) throws StudentDetailsNotFound;
    Student saveStudent(Student student) throws StudentDetailsNotFound, IOException;
    Student updateStudent(Student student) throws StudentDetailsNotFound;
    void deleteStudentById(int rollNo) throws StudentDetailsNotFound;
    //String saveImage(MultipartFile image) throws IOException;
}
