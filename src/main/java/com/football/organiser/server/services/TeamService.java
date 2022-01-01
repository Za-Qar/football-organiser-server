package com.football.organiser.server.services;

import com.football.organiser.server.models.Team;
import com.football.organiser.server.models.TeamMember;

import java.util.*;
import java.util.concurrent.ExecutionException;

public interface TeamService {
    Map<String, Object> createTeam(final Team team) throws ExecutionException, InterruptedException;
    List<Team> getAllTeams() throws ExecutionException, InterruptedException;
    List<Team> getFilterUserJoinedTeams(final String teamMemberUid) throws ExecutionException, InterruptedException;
    Map<String, Object> getTeamById(final int id);
    boolean updateTeamById(final int id);
    boolean deleteTeamById(final int id);

    Map<String, Object> addPlayersToGroup(final TeamMember teamMember) throws ExecutionException, InterruptedException;
}
