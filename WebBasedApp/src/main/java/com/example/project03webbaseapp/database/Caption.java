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

    private Integer userId; // to store the ID of the account who made the caption

    private Integer pictureId;

    private String content; // to store what the caption is

    private Date captionDate; // store date caption was made
    private Time captionTime;

    private Integer captionLikes;


    public Caption(Integer userId, String content, Date captionDate, Time captionTime, Integer pictureId){
        this.userId = userId;
        this.content = content;
        this.captionDate = captionDate;
        this.captionTime = captionTime;
        this.pictureId = pictureId;

    }


    public Integer getCaptionId() {
        return captionId;
    }

    public void setCaptionId(Integer captionId) {
        this.captionId = captionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCaptionDate() {
        return captionDate;
    }

    public void setCaptionDate(Date captionDate) {
        this.captionDate = captionDate;
    }

    public Time getCaptionTime() {
        return captionTime;
    }

    public void setCaptionTime(Time captionTime) {
        this.captionTime = captionTime;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Caption)) return false;
        Caption caption = (Caption) o;
        return Objects.equals(getCaptionId(), caption.getCaptionId()) && Objects.equals(getUserId(), caption.getUserId()) && Objects.equals(getContent(), caption.getContent()) && Objects.equals(getCaptionDate(), caption.getCaptionDate()) && Objects.equals(getCaptionTime(), caption.getCaptionTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCaptionId(), getUserId(), getContent(), getCaptionDate(), getCaptionTime());
    }

    @Override
    public String toString() {
        return "Caption{" +
                "captionId=" + captionId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", captionDate=" + captionDate +
                ", captionTime=" + captionTime +
                '}';
    }
}
