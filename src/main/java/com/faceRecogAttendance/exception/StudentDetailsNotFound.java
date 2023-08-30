package com.faceRecogAttendance.exception;

public class StudentDetailsNotFound extends Exception{

    public StudentDetailsNotFound() {
    }

    public StudentDetailsNotFound(String message) {
        super(message);
    }

    public StudentDetailsNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
