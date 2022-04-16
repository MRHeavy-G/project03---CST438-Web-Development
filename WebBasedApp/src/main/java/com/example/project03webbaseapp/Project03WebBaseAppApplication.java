package com.example.project03webbaseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Project03WebBaseAppApplication {

    @RequestMapping("/")
    @ResponseBody
    String home(){return "landing_page";}

    public static void main(String[] args) {
        SpringApplication.run(Project03WebBaseAppApplication.class, args);
    }

}
