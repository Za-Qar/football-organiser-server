package com.football.organiser.server.models;

public class UserInfoInTeam {
    private String photoUrl;
    private String name;
    private String uuid;

    public UserInfoInTeam(String photoUrl, String name, String uuid) {
        this.photoUrl = photoUrl;
        this.name = name;
        this.uuid = uuid;
    }

    public UserInfoInTeam() {}

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
