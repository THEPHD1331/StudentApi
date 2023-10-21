package com.faceRecogAttendance.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "students_4thyear")
@Data
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

}
