package com.football.organiser.server.models;

import java.util.Objects;

public class Team {
    private String teamName;
    private String country;
    private String teamCaptain;
    private String uuid;

    public Team(final String teamName, final String country) {
        this.teamName = teamName;
        this.country = country;
    }

    public Team() {
    }

    public String getTeamName() {
        return this.teamName;
    }

    public String getCountry() {
        return country;
    }

    public String getTeamCaptain() {
        return teamCaptain;
    }

    public String getUuid() {
        return uuid;
    }

    public void setTeamName(final String teamName) {
        this.teamName = teamName;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public void setTeamCaptain(String teamCaptain) {
        this.teamCaptain = teamCaptain;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", country='" + country + '\'' +
                ", teamCaptain='" + teamCaptain + '\'' +
                ", uuid=" + uuid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamName.equals(team.teamName) && country.equals(team.country) && teamCaptain.equals(team.teamCaptain) && uuid.equals(team.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, country, teamCaptain, uuid);
    }
}
