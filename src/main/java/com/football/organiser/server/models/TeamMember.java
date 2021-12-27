package com.football.organiser.server.models;

public class TeamMember {
    private String joinedTimeStamp;
    private int phoneNumber;
    private String photoUrl;
    private String teamMemberName;
    private String teamMemberEmail;
    private String teamNameToJoin;
    private String uid;
    private String gender;


    public TeamMember(String joinedTimeStamp, int phoneNumber, String photoUrl, String teamMemberName, String teamMemberEmail, String teamNameToJoin, String uid, String gender) {
        this.joinedTimeStamp = joinedTimeStamp;
        this.phoneNumber = phoneNumber;
        this.photoUrl = photoUrl;
        this.teamMemberName = teamMemberName;
        this.teamMemberEmail = teamMemberEmail;
        this.teamNameToJoin = teamNameToJoin;
        this.uid = uid;
        this.gender = gender;
    }

    public TeamMember(){}

    public String getJoinedTimeStamp() {
        return joinedTimeStamp;
    }

    public void setJoinedTimeStamp(String joinedTimeStamp) {
        this.joinedTimeStamp = joinedTimeStamp;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
