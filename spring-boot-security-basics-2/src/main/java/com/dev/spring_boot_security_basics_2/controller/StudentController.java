package com.dev.spring_boot_security_basics_2.controller;

import com.dev.spring_boot_security_basics_2.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class StudentController {

    private final List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Student1", 50),
            new Student(2, "Student2", 60),
            new Student(3, "Student3", 70)
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public Student addStudents(@RequestBody Student student, HttpServletRequest request) {
        students.add(student);

        System.out.println("---> request.getRequestedSessionId(): " + request.getRequestedSessionId());

        return student;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
