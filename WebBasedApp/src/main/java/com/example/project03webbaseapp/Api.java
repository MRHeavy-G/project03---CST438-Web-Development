package com.example.project03webbaseapp;

import com.example.project03webbaseapp.database.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.*;


import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/api")
public class Api {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CaptionRepo captionRepo;
    @Autowired
    private PictureRepo pictureRepo;

//  User API endpoints

    @RequestMapping("/getAllUsers")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepo.findAll();
    }

    @RequestMapping("/getUserByUsername")
    public @ResponseBody User getUserByUsername(@RequestParam(defaultValue = "user") String name){
        return userRepo.finderUserByUsername(name);
    }

    @RequestMapping("/getUserByUserId")
    public @ResponseBody User getUserByUserId(@RequestParam(defaultValue = "0") Integer userId){
        return userRepo.findUserByUserId(userId);
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


    //TODO: write query for get all captions

//    Picture API endpoints

}
