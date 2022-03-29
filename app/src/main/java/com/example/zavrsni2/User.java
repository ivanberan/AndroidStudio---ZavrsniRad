package com.example.zavrsni2;

public class User {


    private String username;
    private String firstname;
    private String lastname;
    private String sex;
    private String userID;
    private String email;
    private Integer progress;
    private Integer score;

    public User(){

    }

    public User(String username, String firstname, String lastname, String sex) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
    }

    public User(String username, String firstname, String lastname, String sex, String userID, String email, Integer progress, Integer score) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.userID = userID;
        this.email = email;
        this.progress = progress;
        this.score = score;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

