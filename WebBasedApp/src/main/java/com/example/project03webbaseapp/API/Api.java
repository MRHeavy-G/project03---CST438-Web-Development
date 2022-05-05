package com.example.project03webbaseapp.API;

import com.example.project03webbaseapp.database.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.*;


import org.json.JSONArray;
import org.json.JSONObject;

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

    final apiKey apiKey = new apiKey();
    public final String ACCESS_KEY = apiKey.getAccessKey();
    public final String SECRET_KEY = apiKey.getSecretKey();


    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CaptionRepo captionRepo;
    @Autowired
    private PictureRepo pictureRepo;

    @Autowired
    NetworkDAO networkDAO;

//  User API endpoints




    @RequestMapping("/getUserByUsername")
    public @ResponseBody User getUserByUsername(@RequestParam(defaultValue = "user") String name){
        return UserRepo.findUserByUsername(name);
    }

    @RequestMapping("/getUserByUserId")
    public @ResponseBody User getUserByUserId(@RequestParam(defaultValue = "0") Integer userId){
        return userRepo.findUserByUserId(userId);
    }

    @RequestMapping("/usernameIsTaken")
    public @ResponseBody Boolean usernameIsTaken(@RequestParam(defaultValue = "user") String username){
        return userRepo.existsUserByUsername(username);
    }

    @PostMapping("/signup")
    public String addUser(@RequestParam String username,
                          @RequestParam String fName,
                          @RequestParam String lName,
                          @RequestParam String password,
                          @RequestParam String profilePicUrl){
        User user = new User(username, fName, lName, password, profilePicUrl);

        if(!usernameIsTaken(username)){
            userRepo.save(user);
            return "redirect:/landing_page";
        }
        return "redirect:/landing_page";
    }

//    Caption API endpoints

    @RequestMapping("/getCaptionById")
    public @ResponseBody Caption getCaptionById(@RequestParam(defaultValue = "0") Integer id){
        return captionRepo.findCaptionByCaptionId(id);
    }

    @RequestMapping("/getCaptionByUserId")
    public @ResponseBody Caption getCaptionByUserId(@RequestParam(defaultValue = "0") Integer id){
        return captionRepo.findCaptionByUserId(id);
    }


}
