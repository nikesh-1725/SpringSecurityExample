package com.example.SpringSecurityTalusko.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
public class HelloController {

    @GetMapping
    public String greet(HttpServletRequest request)
    {
        return "Welocome to Spring security "+request.getSession().getId();
    }

}
