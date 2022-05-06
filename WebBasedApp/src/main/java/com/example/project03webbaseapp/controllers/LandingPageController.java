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
import java.util.ArrayList;
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
        //@ResponseBody
    String home(Model model){
        List<Picture> pictureList = pictureRepo.findAll();

        model.addAttribute("pictureURL",pictureList.get(12).getPictureUrl());

        return "landing_page";
    }


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

    @RequestMapping(value= "/login_test", method = RequestMethod.GET)
    public String testLogin(){return "login";}

    // calling the login sessions

    @RequestMapping("/login")
    public String login(Model model){
        return "logged_in.html";
    }

    // Calling in the loggin features in order to get the post method
    @PostMapping("/login_check")
    public String checkLogin(@RequestParam String username,@RequestParam String password, HttpServletRequest sessionLink){
        User checkUser = UserRepo.findUserByUsername(username);
        List<String> sessionList = new ArrayList<>();
        // create an if statement to check out user empty
        if(checkUser == null){
            return "Double Check Your Username";
        }

        if(checkUser.getPassword().equals(password)){
            //Enters the username
            sessionList.add(username);
            //Enters if is an admin
            sessionList.add("isAdmin");
            sessionLink.getSession().setAttribute("sessionList", sessionList);
            return "redirect:/logged_in";
        }else{
            return "What will we do with you if you cant get the password right";
        }

    }



    // String processing for testing
    @PostMapping("/string_testing")
    public String addUser(@RequestParam String username, @RequestParam String password){
        System.out.println(username + " : " + password);
        return "redirect:/login";
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

    @RequestMapping("/usernameIsTaken")
    public @ResponseBody Boolean usernameIsTaken(@RequestParam(defaultValue = "user") String username){
        return userRepo.existsUserByUsername(username);
    }
    //Structure for Session Calls
    @RequestMapping("/getActiveUser")
    public User getActiveUser(HttpSession session){
        User user = UserRepo.findUserByUsername(((List<String>)session.getAttribute("sessionList")).get(0));

        return user;
    }

    @GetMapping(path="/getAllUsers")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }


    /**
    @PostMapping("/login")
    public String loginA(@ModelAttribute("user") User user, HttpServletRequest sessionLink){

        User user1 = UserRepo.findUserByUsername(user.getUsername());
        List<String> sessionVar = new ArrayList<>();// this holds the session variables
        if (user1 == null) {
            return "User does not exist";
        }

        if(user1.getPassword().equals(user.getPassword())) {
            sessionVar.add(user.getUsername()); // we add a variable
            sessionVar.add("isAuthenticated"); // we add another variable
            sessionLink.getSession().setAttribute("sessionVar", sessionVar);// we save the list to the session link
            return "redirect:/logged_in";
        } else {
            return "Password is incorrect";
        }
    }
    */

/**
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
    */


}
