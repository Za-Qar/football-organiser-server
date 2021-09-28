package com.football.organiser.server.services;

import com.football.organiser.server.models.Team;
import com.football.organiser.server.models.TeamMember;
import com.football.organiser.server.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Component
public class TeamServiceImpl implements TeamService{

    @Autowired
    final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Map<String, Object> createTeam(final Team team) throws ExecutionException, InterruptedException {
        return teamRepository.createTeam(team);
    }

    @Override
    public List<Team> getAllTeams() throws ExecutionException, InterruptedException
    {
        return teamRepository.getAllTeams();
    }

    @Override
    public Map<String, Object> getTeamById(int id) {
        return null;
    }

    @Override
    public boolean updateTeamById(int id) {
        return false;
    }

    @Override
    public boolean deleteTeamById(int id) {
        return false;
    }

    @Override
    public Map<String, Object> addPlayersToGroup(TeamMember teamMember) throws ExecutionException, InterruptedException {
        return teamRepository.addPlayersToGroup(teamMember);
    }
}
