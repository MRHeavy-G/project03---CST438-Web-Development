package com.example.project03webbaseapp.database;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
import javax.persistence.*;

@Entity
public class User {

    @Id
    private Integer userId;

    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String profilePicture;

    // do we want a history of captions they have made?

    public User(String username, String firstname, String lastname, String password, String profilePicture){
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.profilePicture = profilePicture;

    }

    public User() {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getFirstname(), user.getFirstname()) && Objects.equals(getLastname(), user.getLastname()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getProfilePicture(), user.getProfilePicture());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername(), getFirstname(), getLastname(), getPassword(), getProfilePicture());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }
}
