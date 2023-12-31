package com.faceRecogAttendance.service;

import com.faceRecogAttendance.entity.Student;
import com.faceRecogAttendance.exception.StudentDetailsNotFound;
import com.faceRecogAttendance.repository.StudentRepository;
import com.faceRecogAttendance.util.ImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepo;

    @Override
    public List<Student> getAllStudents() throws StudentDetailsNotFound {
        List<Student> students= studentRepo.findAll();

        if(CollectionUtils.isEmpty(students)){
            throw new StudentDetailsNotFound("Student details not found");
        }
        log.info("Getting all Students");
        return students;
    }

    @Override
    public Student getStudentById(int rollNo) throws StudentDetailsNotFound {
        Optional<Student> result = studentRepo.findById(rollNo);
        Student theStu=result.get();

        if(result==null) {
            throw new StudentDetailsNotFound("Did not find the Student Id: " + rollNo);
        }
        log.info("Getting student by rolNo");
        return theStu;
    }

    @Override
    public Student getStudentByName(String name) throws StudentDetailsNotFound {
        Optional<Student> result = studentRepo.findByStudentName(name);
        Student theStu=result.get();

        if(result==null){
            throw new StudentDetailsNotFound("Did not find the Student Name: "+ name);
        }
        log.info("Getting student by Name");
        return theStu;
    }

    @Override
    public Student saveStudent(Student student) throws StudentDetailsNotFound, IOException {

        log.info("Save Student Impl");
        //studentRepo.save(Student.builder().image(ImageUtil.compressImage(image.getBytes())).build());
        return studentRepo.save(student) ;
    }

    @Override
    public Student updateStudent(Student student) throws StudentDetailsNotFound {
        log.info("Update Student Impl");
        return studentRepo.save(student);
    }

    @Override
    public void deleteStudentById(int rollNo) throws StudentDetailsNotFound {
        log.info("Delete Student impl");
        studentRepo.deleteById(rollNo);
    }

    @Override
    public Student getImageById(int rollNo) {
        return studentRepo.findById(rollNo).get();
    }

//    @Override
//    public String saveImage(MultipartFile image) throws IOException {
//        studentRepo.save(Student.builder().image(ImageUtil.compressImage(image.getBytes())).build());
//
//        return "Image has been Uploaded successfully: "+ image.getName()+" of size: "+image.getSize();
//    }
}
