package com.example.cv.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
