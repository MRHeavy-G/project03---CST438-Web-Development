package com.example.project03webbaseapp.API;

import com.example.project03webbaseapp.database.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

// java url packages



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
    public User getUserByUsername(@PathVariable Integer id){
        User user = userRepo.findUserByUserId(id);
    }


}
