package com.football.organiser.server.models;

import java.util.Objects;

public class Team {
    private String teamName;
    private String country;
    private String teamCaptain;
    private String description;
    private String gameType;
    private String uuid;

    public Team(String teamName, String country, String teamCaptain, String description, String gameType, String uuid) {
        this.teamName = teamName;
        this.country = country;
        this.teamCaptain = teamCaptain;
        this.description = description;
        this.gameType = gameType;
        this.uuid = uuid;
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

    public String getDescription() {
        return description;
    }

    public String getGameType() {
        return gameType;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
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
                ", description='" + description + '\'' +
                ", gameType='" + gameType + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamName, team.teamName) && Objects.equals(country, team.country) && Objects.equals(teamCaptain, team.teamCaptain) && Objects.equals(description, team.description) && Objects.equals(gameType, team.gameType) && Objects.equals(uuid, team.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, country, teamCaptain, description, gameType, uuid);
    }
}
