package com.example.project03webbaseapp.controllers;


import com.example.project03webbaseapp.API.apiKey;
import com.example.project03webbaseapp.database.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class SessionController {

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
}
