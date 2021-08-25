package com.football.organiser.server.services;

import com.football.organiser.server.models.Team;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface TeamService {
    Map<String, String> createTeam(final Team team) throws ExecutionException, InterruptedException;
    List<Team> getAllTeams();
    List<Team> getTeamById(final int id);
    boolean updateTeamById(final int id);
    boolean deleteTeamById(final int id);
}
