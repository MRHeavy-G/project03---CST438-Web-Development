package com.example.project03webbaseapp;

import com.example.project03webbaseapp.API.apiKey;
import com.example.project03webbaseapp.database.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.project03webbaseapp.database.*;

import com.example.project03webbaseapp.API.apiKey;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@SpringBootApplication
public class Project03WebBaseAppApplication {

    public com.example.project03webbaseapp.API.apiKey apiKey = new apiKey();
    public final String ACCESS_KEY = apiKey.getAccessKey();
    public final String SECRET_KEY = apiKey.getSecretKey();

//    @RequestMapping("/")
//    //@ResponseBody
//    String home(Model model){return "landing_page";}



    public static void main(String[] args) {
        SpringApplication.run(Project03WebBaseAppApplication.class, args);

        String print = "https://api.unsplash.com/search/photos?query=funny&client_id=" + com.example.project03webbaseapp.API.apiKey.class;

        System.out.println();
    }




}
