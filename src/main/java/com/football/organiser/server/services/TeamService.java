package com.football.organiser.server.services;

import com.football.organiser.server.models.Team;
import com.football.organiser.server.models.TeamMember;

import java.util.*;
import java.util.concurrent.ExecutionException;

public interface TeamService {
    Map<String, Object> createTeam(final Team team) throws ExecutionException, InterruptedException;
    List<Team> getAllTeams() throws ExecutionException, InterruptedException;
    List<Team> getFilterUserJoinedTeams(final String teamMemberUid) throws ExecutionException, InterruptedException;
    List<Team> getAllUserJoinedTeams(final List<String> teamNames) throws ExecutionException, InterruptedException;
    Team getTeamByName(final String teamName) throws ExecutionException, InterruptedException;
    boolean updateTeamById(final int id);
    boolean deleteTeamById(final int id);

    Map<String, Object> addPlayersToTeam(final TeamMember teamMember) throws ExecutionException, InterruptedException;
}
