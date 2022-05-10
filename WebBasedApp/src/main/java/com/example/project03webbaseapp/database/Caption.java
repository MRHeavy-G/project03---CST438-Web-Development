package com.example.project03webbaseapp.database;



import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@EnableScheduling
@Entity
public class Caption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer captionId;

    private String username; // to store the ID of the account who made the caption

    private Integer pictureId;

    public String content; // to store what the caption is

    private String dateTime;

    private Integer captionLikes;


    public Caption(String username, String content, String dateTime, Integer pictureId){
        this.username = username;
        this.content = content;
        this.dateTime = dateTime;
        this.pictureId = pictureId;

    }


    public Integer getCaptionId() {
        return captionId;
    }

    public void setCaptionId(Integer captionId) {
        this.captionId = captionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getCaptionLikes() {
        return captionLikes;
    }

    public void setCaptionLikes(Integer captionLikes) {
        this.captionLikes = captionLikes;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Caption(){

    }


}
