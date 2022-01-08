package com.football.organiser.server.models;

public class UserInfoInTeam {
    private String photoUrl;
    private String name;
    private String uid;

    public UserInfoInTeam(String photoUrl, String name, String uid) {
        this.photoUrl = photoUrl;
        this.name = name;
        this.uid = uid;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
