package com.faceRecogAttendance.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "students_4thyear")
public class Student {

    @Id
    @Column(name = "Roll_no")
    private int rollNo;

    @Column(name = "Name")
    private String studentName;

    @Column(name = "year")
    private String year;

//    @Column(name = "Image", length = 40000000)
//    @Lob
//    private byte[] image;


    public Student(int rollNo, String studentName, String year) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.year = year;
    }

    public Student(){

    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
