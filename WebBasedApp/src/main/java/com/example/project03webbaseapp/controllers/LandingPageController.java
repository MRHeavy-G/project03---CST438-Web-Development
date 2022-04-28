package com.example.project03webbaseapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LandingPageController {

    @RequestMapping(value="/landing_page", method= RequestMethod.GET)
    public String getLogin() {
        return "landing_page";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String getSettings(){return "settings";}
}
