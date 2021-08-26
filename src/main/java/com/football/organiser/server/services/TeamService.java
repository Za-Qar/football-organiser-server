package com.football.organiser.server.services;

import com.football.organiser.server.models.Team;
import com.football.organiser.server.models.TeamMember;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface TeamService {
    Map<String, Object> createTeam(final Team team) throws ExecutionException, InterruptedException;
    Map<String, Object> getAllTeams() throws ExecutionException, InterruptedException;
    Map<String, Object> getTeamById(final int id);
    boolean updateTeamById(final int id);
    boolean deleteTeamById(final int id);

    Map<String, Object> addPlayersToGroup(final TeamMember teamMember) throws ExecutionException, InterruptedException;
}
