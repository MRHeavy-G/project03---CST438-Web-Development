package com.example.project03webbaseapp.controllers;

import com.example.project03webbaseapp.API.apiKey;
import com.example.project03webbaseapp.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/logged_in")
public class LoggedInController {

    @Autowired
    private PictureRepo picRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CaptionRepo captionRepo;

    final com.example.project03webbaseapp.API.apiKey apiKey = new apiKey();
    public final String ACCESS_KEY = apiKey.getAccessKey();
    public final String SECRET_KEY = apiKey.getSecretKey();

    NetworkDAO networkDAO = new NetworkDAO();

    @RequestMapping("/logged_in")
    String home(Model model){
        var pictureList = picRepo.findAll();

        //Picture dailyPic = pictureList.get(12);
        Picture loggedInPic = pictureList.get(11);

        List<Caption> capList = captionRepo.findCaptionByPictureId(loggedInPic.getPictureId());

        model.addAttribute("loggedInPic",loggedInPic.getPictureUrl());

        model.addAttribute("capList", capList);

        return "logged_in";
    }


}
