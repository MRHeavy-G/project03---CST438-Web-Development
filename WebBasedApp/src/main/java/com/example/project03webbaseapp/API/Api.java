package com.example.project03webbaseapp.API;

import com.example.project03webbaseapp.database.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.*;

// java url packages
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.JSONObject;


import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/apiEndpoints")
public class Api {

    public apiKey apiKey = new apiKey();
    public final String ACCESS_KEY = apiKey.getAccessKey();
    public final String SECRET_KEY = apiKey.getSecretKey();


    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CaptionRepo captionRepo;
    @Autowired
    private PictureRepo pictureRepo;

//  User API endpoints

    //TODO doesnt like these IDK WHY:(
//    @RequestMapping("/getAllUsers")
//    public @ResponseBody Iterable<User> getAllUsers(){
//        return userRepo.findAll();
//    }
//
//    @RequestMapping("/getUserByUsername")
//    public @ResponseBody User getUserByUsername(@RequestParam(defaultValue = "user") String name){
//        return userRepo.finderUserByUsername(name);
//    }
//
//    @RequestMapping("/getUserByUserId")
//    public @ResponseBody User getUserByUserId(@RequestParam(defaultValue = "0") Integer userId){
//        return userRepo.findUserByUserId(userId);
//    }

//    Caption API endpoints

    @RequestMapping("/getCaptionById")
    public @ResponseBody Caption getCaptionById(@RequestParam(defaultValue = "0") Integer id){
        return captionRepo.findCaptionByCaptionId(id);
    }

    @RequestMapping("/getCaptionByUserId")
    public @ResponseBody Caption getCaptionByUserId(@RequestParam(defaultValue = "0") Integer id){
        return captionRepo.findCaptionByUserId(id);
    }


    //TODO: write query for get all captions

//    Picture API endpoints

    @RequestMapping("/setPicture")
    public void setPicture(){
        String endpoint = "https://api.unsplash.com/search/photos?query=funny&client_id=" + ACCESS_KEY;

        }

}