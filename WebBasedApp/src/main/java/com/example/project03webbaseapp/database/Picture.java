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
    private String pictureUrl;


    @OneToMany
    private List<Caption> captionList;

    public Picture(){
        // idk why we need this...
    }

    public Picture(String pictureName, String pictureUrl) {
        this.pictureName = pictureName;
        this.pictureUrl = pictureUrl;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public List<Caption> getCaptionList() {
        return captionList;
    }

    public void setCaptionList(List<Caption> captionList) {
        this.captionList = captionList;
    }
}
