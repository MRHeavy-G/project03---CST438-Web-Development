package com.example.project03webbaseapp.API;

import com.example.project03webbaseapp.database.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

// java url packages



import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/api")
public class Api {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PictureRepo pictureRepo;

    @Autowired
    private CaptionRepo captionRepo;

    @GetMapping("/getUserByUsername/{id}")
    public User getUserByUserId(@PathVariable Integer id){
        return  userRepo.findUserByUserId(id);
    }

    @GetMapping("/getPictureByPictureId/{id}")
    public Picture getPictureByPictureId(@PathVariable Integer id){
        return pictureRepo.findPictureByPictureId(id);
    }

    @GetMapping("/getAllCaptionsByUser/<username>")
    public List<Caption> getAllCaptionsByUser(@PathVariable String username){
        return captionRepo.findAllByUsername(username);
    }

    @GetMapping("/findPictureCaptions/{pictureID}")
    public List<Caption> getAllCaptionsForPicture(@PathVariable Integer pictureId){
        return captionRepo.findCaptionByPictureId(pictureId);



}
