package com.football.organiser.server.models;

public class EmailTeamName {
    private String email;
    private String teamName;

    public EmailTeamName(String email, String teamName) {
        this.email = email;
        this.teamName = teamName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
