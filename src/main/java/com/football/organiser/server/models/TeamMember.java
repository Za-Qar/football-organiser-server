package com.football.organiser.server.models;

public class TeamMember {

    private String teamMemberName;
    private String joinedTimeStamp;
    private String photoUrl;
    private String uuid;
    private String location;
    private String phoneNumber;
    private String teamName;

    public TeamMember(String teamMemberName, String joinedTimeStamp, String photoUrl, String uuid, String location, String phoneNumber, String teamName) {
        this.teamMemberName = teamMemberName;
        this.joinedTimeStamp = joinedTimeStamp;
        this.photoUrl = photoUrl;
        this.uuid = uuid;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.teamName = teamName;
    }

    public String getTeamMemberName() {
        return teamMemberName;
    }

    public String getJoinedTimeStamp() {
        return joinedTimeStamp;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getUuid() {
        return uuid;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamMemberName(String teamMemberName) {
        this.teamMemberName = teamMemberName;
    }

    public void setJoinedTimeStamp(String joinedTimeStamp) {
        this.joinedTimeStamp = joinedTimeStamp;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "teamMemberName='" + teamMemberName + '\'' +
                ", joinedTimeStamp='" + joinedTimeStamp + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", uuid='" + uuid + '\'' +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }

}
