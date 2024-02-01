package com.example.controller;

import com.example.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

//http://localhost:8080/api/student
    private static final List<Student> STUDENT_LIST = Arrays.asList(
            new Student(1, "james Bond"),
            new Student(2, "maria"),
            new Student(3, "smith")
    );
    //http://localhost:8080/api/student/1
    //find first student who's id is studentid given in url

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENT_LIST.stream().
                filter(student -> studentId.equals(student.getStudentId())).
                findFirst().orElseThrow(() -> new IllegalStateException("student " + studentId + " does not exit"));
    }
}
