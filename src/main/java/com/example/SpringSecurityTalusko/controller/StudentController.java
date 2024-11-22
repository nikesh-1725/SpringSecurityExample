package com.example.SpringSecurityTalusko.controller;


import com.example.SpringSecurityTalusko.dto.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students= new ArrayList<>(Arrays.asList(new Student(1, "Naveen", 10), new Student(2, "Ravi", 20)))    ;

    @GetMapping ("/students")
    public List<Student> getStudents()
    {
        return students;

    }

    @GetMapping("/csrf-token")
    public CsrfToken generateToken(HttpServletRequest request)
    {
        return (CsrfToken)request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student s)
    {
        students.add(s);
        return s;
    }

}
