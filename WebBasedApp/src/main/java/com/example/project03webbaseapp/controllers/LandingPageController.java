package com.example.project03webbaseapp.controllers;

import com.example.project03webbaseapp.API.apiKey;
import com.example.project03webbaseapp.database.NetworkDAO;
import com.example.project03webbaseapp.database.Picture;
import com.example.project03webbaseapp.database.PictureRepo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class LandingPageController {

    @Autowired
    private PictureRepo pictureRepo;

    final apiKey apiKey = new apiKey();
    public final String ACCESS_KEY = apiKey.getAccessKey();
    public final String SECRET_KEY = apiKey.getSecretKey();

    NetworkDAO networkDAO = new NetworkDAO();


    @RequestMapping("/")
        //@ResponseBody
    String home(Model model){
        List<Picture> pictureList = pictureRepo.findAll();

        model.addAttribute("pictureURL",pictureList.get(12).getPictureUrl());


        return "landing_page";}


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


    @RequestMapping(value = "/Landing", method = RequestMethod.GET)
    public String setPicture(Model model) throws Exception {
        List<Picture> pictureList = new ArrayList<Picture>();

        String endpoint = networkDAO.request("https://api.unsplash.com/search/photos?query=funny&client_id=" + ACCESS_KEY);

        JSONObject root = new JSONObject(endpoint);

        JSONArray pictures = root.getJSONArray("results");

        //System.out.println(pictures);

        for(int i = 0; i < pictures.length(); i++){
            // Json Data
            JSONObject jsonPic = pictures.getJSONObject(i);

            //new picture object
            Picture picture = new Picture();

            String name = jsonPic.optString("description", null);

            System.out.println(name);

            // TODO not sure if this will work:(
            JSONObject jsonURL = jsonPic.getJSONObject("urls");

            String url = jsonURL.getString("regular");

            System.out.println(url);
            try {
                picture.setPictureName(name);
                picture.setPictureUrl(url);

            }catch(JSONException je){
                picture.setPictureName("nothing");
                picture.setPictureUrl("no url");
            }
            pictureList.add(picture);

            pictureRepo.save(picture);
        }


        System.out.println(pictureList.get(0).getPictureUrl());


       // model.addAttribute("msg", "Welcome to the Netherlands!");


        model.addAttribute("picUrl", pictureList.get(0).getPictureUrl());



        return "redirect/";
    }


}
