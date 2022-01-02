package com.football.organiser.server.models;

import java.util.List;

public class User {
    private String name;
    private String email;
    private String uid;
    private String photoUrl;
    private List<String> teamsJoined;
    private long phoneNumber;

    public User(String name, String email, String uid, String photoUrl, List<String> teamsJoined, long phoneNumber) {
        this.name = name;
        this.email = email;
        this.uid = uid;
        this.photoUrl = photoUrl;
        this.teamsJoined = teamsJoined;
        this.phoneNumber = phoneNumber;
    }

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<String> getTeamsJoined() {
        return teamsJoined;
    }

    public void setTeamsJoined(List<String> teamsJoined) {
        this.teamsJoined = teamsJoined;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
