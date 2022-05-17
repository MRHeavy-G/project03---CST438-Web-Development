package com.example.project03webbaseapp;

import com.example.project03webbaseapp.API.apiKey;
import com.example.project03webbaseapp.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.project03webbaseapp.database.*;

import com.example.project03webbaseapp.API.apiKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@SpringBootApplication
public class Project03WebBaseAppApplication {

    public com.example.project03webbaseapp.API.apiKey apiKey = new apiKey();
    public final String ACCESS_KEY = apiKey.getAccessKey();
    public final String SECRET_KEY = apiKey.getSecretKey();

//    @RequestMapping("/")
//    //@ResponseBody
//    String home(Model model){return "landing_page";}

    @Autowired
    private UserRepo UserRepo;
    @Autowired
    private CaptionRepo captionRepo;
    @Autowired
    private PictureRepo pictureRepo;

    @Autowired
    NetworkDAO networkDAO;



    public static void main(String[] args) {
        SpringApplication.run(Project03WebBaseAppApplication.class, args);

        String print = "https://api.unsplash.com/search/photos?query=funny&client_id=" + com.example.project03webbaseapp.API.apiKey.class;

        System.out.println();
    }


    public boolean isAuthenticated(HttpSession session){
        boolean returnVal = false;
        if(session.getAttribute("sVar") != null){
            if ( ((List<String>)session.getAttribute("sVar")).get(1)!= null){
                returnVal = true;
            }
        }
        return returnVal;
    }


    // example of post method being used for logging in
    @PostMapping("/login_check")
    public String attemptLogin(@ModelAttribute("user") User user, HttpServletRequest sessionLink) {
        User user1 = UserRepo.findUserByUsername(user.getUsername());
        List<String> sVar = new ArrayList<>();// this holds the session variables
        if (user1 == null) {
            return "User does not exist";
        }

        if(user1.getPassword().equals(user.getPassword())) {
            sVar.add(user.getUsername()); // we add a variable
            sVar.add("isAuthenticated"); // we add another variable
            sessionLink.getSession().setAttribute("sVar", sVar);// we save the list to the session link
            return "redirect:/logged_in";
        } else {
            return "Password is incorrect";
        }
    }

    @RequestMapping("/homePage")
    public String landingPage(Model model, HttpSession session) {
        //String uri = "https://localhost:8080/HomePage";
        //RestTemplate restTemplate = new RestTemplate();
        //User user = restTemplate.getForObject(uri, User.class);
        User user = null;

        if(isAuthenticated(session)){
            user = UserRepo.findUserByUsername(((List<String>)session.getAttribute("sessionVar")).get(0));
            model.addAttribute("user", user);
            return "logged_in";
        }
        else{
            return "redirect:/landing_page";
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

            UserRepo.save(user);
            return "redirect:/landing_page";
        }
        return "redirect:/landing_page";
    }

    @RequestMapping("/usernameIsTaken")
    public @ResponseBody Boolean usernameIsTaken(@RequestParam(defaultValue = "user") String username){
        return UserRepo.existsUserByUsername(username);
    }
    //Structure for Session Calls
    @RequestMapping("/getActiveUser")
    public User getActiveUser(HttpSession session){
        User user = UserRepo.findUserByUsername(((List<String>)session.getAttribute("sessionList")).get(0));

        return user;
    }

    @RequestMapping("/getUSERNAME")
    public String getUSERNAME(HttpSession session){
        User user = UserRepo.findUserByUsername(((List<String>)session.getAttribute("sessionList")).get(0));
        return user.getUsername();
    }

    @GetMapping(path="/getAllUsers")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return UserRepo.findAll();
    }


    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        clearSessionVariables(session);
        return "landing_page";
    }


    public void clearSessionVariables(HttpSession session){
        session.invalidate();
    }




}
