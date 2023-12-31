package com.faceRecogAttendance.controller;

import com.faceRecogAttendance.entity.Student;
import com.faceRecogAttendance.exception.StudentDetailsNotFound;
import com.faceRecogAttendance.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Student> getAllStudents() throws StudentDetailsNotFound {
        List<Student> students = studentService.getAllStudents();
        if (CollectionUtils.isEmpty(students)){
            throw new StudentDetailsNotFound("Student details not found");
        }
        return students;
    }

    @GetMapping("/rollNo")
    @CrossOrigin(origins = "http://localhost:3000")
    public Student getStudentById(@RequestParam int rollNo) throws StudentDetailsNotFound {

        Student student = studentService.getStudentById(rollNo);

        if (student == null) {
            throw new RuntimeException("Student not Found - " + rollNo);
        }
        return student;
    }

    @GetMapping("/name")
    @CrossOrigin(origins = "http://localhost:3000")
    public Student getStudentByName(@RequestParam("studentName") String studentName)
            throws StudentDetailsNotFound {

        Student student = studentService.getStudentByName(studentName);

        if (student == null) {
            throw new RuntimeException("Student not Found - " + studentName);
        }
        return student;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping  // Post request to add a new student
    public Student addEmployee(@RequestBody Student student) throws StudentDetailsNotFound, IOException {

        return studentService.saveStudent(student);
    }

//    @PostMapping
//    @CrossOrigin(origins = "http://localhost:3000")
//    public Student addStudent(@RequestParam("rollNo") int rollNo, @RequestParam("name") String name,
//                              @RequestParam("attendance") String attendance,
//                              @RequestParam("image") MultipartFile image)
//            throws StudentDetailsNotFound, IOException, SQLException {
//
//        byte[] bytesImage = image.getBytes();
//        //Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
//
//           Student student= new Student();
//           student.setRollNo(rollNo);
//           student.setStudentName(name);
//           student.setAttendance(attendance);
//           student.setDate(new Date());
//           student.setImage(bytesImage);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        //Student studentMapper= objectMapper.readValue(student, Student.class);
//        return studentService.saveStudent(student);
//    }

//    @GetMapping("/display")
//    public ResponseEntity<byte[]> displayImage(@RequestParam("rollNo") int rollNo) throws IOException, SQLException, StudentDetailsNotFound {
//        Student image = studentService.getImageById(rollNo);
//        byte [] imageBytes = null;
//        imageBytes = image.getImage();
//        HttpHeaders headers= new HttpHeaders();
//        headers.setContentType(MediaType.IMAGE_PNG);
//        //.getClass(1,(int) image.getImage().length);
//        //return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
//
//        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
//    }

//    @PostMapping("/image")
//    public String addImage(@RequestParam("Image") MultipartFile image) throws IOException {
//        System.out.println(image.getName());
//        System.out.println(image.getSize());
//
//        return "Image has been uploaded successfully "+ studentService.saveImage(image);
//    }

//    @PutMapping
//    public Student updateStudent(@RequestParam("rollNo") int rollNo, @RequestParam("name") String name,
//                              @RequestParam("attendance") String attendance,
//                              @RequestParam("image") MultipartFile image)
//            throws StudentDetailsNotFound, IOException, SQLException {
//
//        byte[] bytesImage = image.getBytes();
//
//        Student student = new Student();
//        student.setRollNo(rollNo);
//        student.setStudentName(name);
//        student.setAttendance(attendance);
//       // student.setDate(new Date());
//        student.setImage(bytesImage);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//
//        return studentService.saveStudent(student);
//    }

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
