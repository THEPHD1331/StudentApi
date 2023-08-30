package com.faceRecogAttendance.repository;

import com.faceRecogAttendance.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByStudentName(String Name);
}
