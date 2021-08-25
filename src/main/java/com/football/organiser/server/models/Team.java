package com.football.organiser.server.models;

public class Team {
    private String teamName;
    private String country;

    public Team(final String teamName, final String country) {
        this.teamName = teamName;
        this.country = country;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public String getCountry() {
        return country;
    }

    public void setTeamName(final String teamName) {
        this.teamName = teamName;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + teamName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
