package com.example.project03webbaseapp.database;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pictureId;

    private String pictureName;

    @OneToMany
    private List<Caption> captionList;

}
