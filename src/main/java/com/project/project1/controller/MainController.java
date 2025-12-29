package com.project.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/main")
    @ResponseBody
    public String mainPage() {
        return "hi";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String adminPage() {
        return "admin";
    }

}
