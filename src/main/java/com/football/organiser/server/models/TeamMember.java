package com.football.organiser.server.models;

public class TeamMember {
    private String joinedTimeStamp;
    private long phoneNumber;
    private String photoUrl;
    private String teamMemberName;
    private String teamMemberEmail;
    private String teamNameToJoin;
    private String uuid;
    private String gender;


    public TeamMember(String joinedTimeStamp, int phoneNumber, String photoUrl, String teamMemberName, String teamMemberEmail, String teamNameToJoin, String uuid, String gender) {
        this.joinedTimeStamp = joinedTimeStamp;
        this.phoneNumber = phoneNumber;
        this.photoUrl = photoUrl;
        this.teamMemberName = teamMemberName;
        this.teamMemberEmail = teamMemberEmail;
        this.teamNameToJoin = teamNameToJoin;
        this.uuid = uuid;
        this.gender = gender;
    }

    public TeamMember(){}

    public String getJoinedTimeStamp() {
        return joinedTimeStamp;
    }

    public void setJoinedTimeStamp(String joinedTimeStamp) {
        this.joinedTimeStamp = joinedTimeStamp;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTeamMemberName() {
        return teamMemberName;
    }

    public void setTeamMemberName(String teamMemberName) {
        this.teamMemberName = teamMemberName;
    }

    public String getTeamMemberEmail() {
        return teamMemberEmail;
    }

    public void setTeamMemberEmail(String teamMemberEmail) {
        this.teamMemberEmail = teamMemberEmail;
    }

    public String getTeamNameToJoin() {
        return teamNameToJoin;
    }

    public void setTeamNameToJoin(String teamNameToJoin) {
        this.teamNameToJoin = teamNameToJoin;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
