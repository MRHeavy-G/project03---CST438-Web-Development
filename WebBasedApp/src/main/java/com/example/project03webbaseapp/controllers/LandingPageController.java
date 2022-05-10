package com.example.project03webbaseapp.controllers;

import com.example.project03webbaseapp.API.apiKey;
import com.example.project03webbaseapp.database.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


import java.sql.Time;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class LandingPageController {

    @Autowired
    private PictureRepo pictureRepo;

    @Autowired

    private UserRepo userRepo;

    @Autowired

    private CaptionRepo captionRepo;

    final apiKey apiKey = new apiKey();
    public final String ACCESS_KEY = apiKey.getAccessKey();
    public final String SECRET_KEY = apiKey.getSecretKey();

    NetworkDAO networkDAO = new NetworkDAO();


    @RequestMapping("/")
    String home(Model model){
        List<Picture> pictureList = pictureRepo.findAll();

        model.addAttribute("pictureURL",pictureList.get(12).getPictureUrl());

        return "landing_page";
    }

    @PostMapping("/addCaptionToPicture")
    public String addCaptionToPicture(@RequestParam String username,
                                      @RequestParam String caption,
                                      @RequestParam Integer pictureId){
        //public Caption(Integer userId, String content, Date captionDate, Time captionTime, Integer pictureId){

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        String captiondate = formatter.format(date).toString();
        Caption cap = new Caption(username, caption, captiondate, pictureId);

        captionRepo.save(cap);

        return "redirect:/logged_in";
    }

    //model.addAttribute("picUrl", pictureList.get(0).getPictureUrl());


    @RequestMapping(value="/landing_page", method = RequestMethod.GET)
    public String getLogin() {
        return "landing_page";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String getSettings(){return "settings";}

    @RequestMapping(value= "/logged_in", method = RequestMethod.GET)
    public String getLoggedIn(){return "logged_in";}

    @RequestMapping(value= "/profile", method = RequestMethod.GET)
    public String getProfile(){return "profile";}

    @RequestMapping(value="/viewCaptions", method = RequestMethod.GET)
    public String viewCaptions(@RequestParam Integer pictureId, Model model){

        Picture pic = pictureRepo.findPictureByPictureId(pictureId);

        model.addAttribute("picture", pic);

        return "CaptionList";
    }






}
