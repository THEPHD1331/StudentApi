package com.faceRecogAttendance.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "students_4thyear")
public class Student {

    @Id
    @Column(name = "Roll_no")
    private int rollNo;

    @Column(name = "Name")
    private String studentName;

    @Column(name = "year")
    private String year;

//    @Column(name = "Date")
//    private Date date = new Date();

//    @Column(name = "Image", length = 40000000)
//    @Lob
//    private byte[] image;
}
