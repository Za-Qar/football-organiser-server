package com.football.organiser.server.models;

public class Team {
    private String country;
    private String teamCaptain;
    private String teamCaptainEmail;
    private String teamCaptainPhotoUrl;
    private String teamName;
    private String uid;
    private String groupImage;
    private Boolean isPublic;
    private String gameType;
    private String description;

    public Team(String country, String teamCaptain, String teamCaptainEmail, String teamCaptainPhotoUrl, String teamName, String uid, String groupImage, Boolean isPublic, String gameType, String description) {
        this.country = country;
        this.teamCaptain = teamCaptain;
        this.teamCaptainEmail = teamCaptainEmail;
        this.teamCaptainPhotoUrl = teamCaptainPhotoUrl;
        this.teamName = teamName;
        this.uid = uid;
        this.groupImage = groupImage;
        this.isPublic = isPublic;
        this.gameType = gameType;
        this.description = description;
    }

    public Team() {}


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTeamCaptain() {
        return teamCaptain;
    }

    public void setTeamCaptain(String teamCaptain) {
        this.teamCaptain = teamCaptain;
    }

    public String getTeamCaptainEmail() {
        return teamCaptainEmail;
    }

    public void setTeamCaptainEmail(String teamCaptainEmail) {
        this.teamCaptainEmail = teamCaptainEmail;
    }

    public String getTeamCaptainPhotoUrl() {
        return teamCaptainPhotoUrl;
    }

    public void setTeamCaptainPhotoUrl(String teamCaptainPhotoUrl) {
        this.teamCaptainPhotoUrl = teamCaptainPhotoUrl;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGroupImage() {
        return groupImage;
    }

    public void setGroupImage(String groupImage) {
        this.groupImage = groupImage;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
