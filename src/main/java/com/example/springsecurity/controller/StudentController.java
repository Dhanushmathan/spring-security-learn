package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.model.Student;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(101, "Naruto Uzhumaki", "Java"));
        students.add(new Student(102, "Sakura Haruno", "Spring Boot"));
        students.add(new Student(103, "Kakashi Hatake", "Python"));
        students.add(new Student(104, "Itachi Uchiga", "AI"));
        students.add(new Student(105, "Obito Uchiga", "JavaScript"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/admin/students")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }

}
