package com.football.organiser.server.models;

public class Team {
    private String country;
    private String teamCaptain;
    private String teamCaptainEmail;
    private String teamCaptainPhotoUrl;
    private String teamName;
    private String uuid;
    private String groupImage;
    private Boolean isPublic;
    private String gameType;
    private String description;

    public Team(String country, String teamCaptain, String teamCaptainEmail, String teamCaptainPhotoUrl, String teamName, String uuid, String groupImage, Boolean isPublic, String gameType, String description) {
        this.country = country;
        this.teamCaptain = teamCaptain;
        this.teamCaptainEmail = teamCaptainEmail;
        this.teamCaptainPhotoUrl = teamCaptainPhotoUrl;
        this.teamName = teamName;
        this.uuid = uuid;
        this.groupImage = groupImage;
        this.isPublic = isPublic;
        this.gameType = gameType;
        this.description = description;
    }

    public Team() {}


    public String getCountry() {
        return country;
    }

    public String getTeamCaptain() {
        return teamCaptain;
    }

    public String getTeamCaptainEmail() {
        return teamCaptainEmail;
    }

    public String getTeamCaptainPhotoUrl() {
        return teamCaptainPhotoUrl;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getGroupImage() {
        return groupImage;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public String getGameType() {
        return gameType;
    }

    public String getDescription() {
        return description;
    }
}
