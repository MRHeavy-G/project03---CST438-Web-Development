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
        return userRepo.findUserByUsername(name);
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




//    Picture API endpoints

    @PostMapping("/setPicture")
    public Picture setPicture() throws Exception {
        List<Picture> pictureList = new ArrayList<Picture>();

        String endpoint = networkDAO.request("https://api.unsplash.com/search/photos?query=funny&client_id=" + ACCESS_KEY);

        JSONObject root = new JSONObject(endpoint);

        JSONArray pictures = root.getJSONArray("results");

        for(int i = 0; i < pictures.length(); i++){
            // Json Data
            JSONObject jsonPic = pictures.getJSONObject(i);

            //new picture object
            Picture picture = new Picture();

            String name = jsonPic.getString("description");

            // TODO not sure if this will work:(
            JSONObject jsonURL = jsonPic.getJSONObject("urls");

            String url = jsonURL.getString("regular");

            picture.setPictureName(name);
            picture.setPictureUrl(url);

            pictureList.add(picture);
        }

        return pictureList.get(0);
    }

}
