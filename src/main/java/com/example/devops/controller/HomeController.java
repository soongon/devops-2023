package com.example.devops.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "CI/CD 앤서블을 이용해서 했습니다.";
    }
}
