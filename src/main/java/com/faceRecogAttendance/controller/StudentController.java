package com.faceRecogAttendance.controller;

import com.faceRecogAttendance.entity.Student;
import com.faceRecogAttendance.exception.StudentDetailsNotFound;
import com.faceRecogAttendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() throws StudentDetailsNotFound {
        List<Student> students = studentService.getAllStudents();
        if (CollectionUtils.isEmpty(students)){
            throw new StudentDetailsNotFound("Student details not found");
        }
        return students;
    }

    @GetMapping("/rollNo")
    public Student getStudentById(@PathVariable int rollNo) throws StudentDetailsNotFound {

        Student student = studentService.getStudentById(rollNo);

        if (student == null) {
            throw new RuntimeException("Student not Found - " + rollNo);
        }
        return student;
    }

    @GetMapping("/name")
    public Student getStudentByName(@RequestParam("studentName") String studentName) throws StudentDetailsNotFound {

        Student student = studentService.getStudentByName(studentName);

        if (student == null) {
            throw new RuntimeException("Student not Found - " + studentName);
        }
        return student;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) throws StudentDetailsNotFound {

        return studentService.saveStudent(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) throws StudentDetailsNotFound {

        return studentService.updateStudent(student);
    }

    @DeleteMapping
    public String deleteStudent(@RequestParam("rollNo") int rollNo) throws StudentDetailsNotFound {

        Student temp= studentService.getStudentById(rollNo);
        if(temp==null) {
            throw new StudentDetailsNotFound("Student rollNo not found - " + rollNo);
        }
        studentService.deleteStudentById(rollNo);

        return "Deleted Student rollNo: "+rollNo;
    }
}
