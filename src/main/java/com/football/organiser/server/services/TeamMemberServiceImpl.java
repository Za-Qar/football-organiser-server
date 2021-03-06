package com.football.organiser.server.services;

import java.util.*;
import java.util.concurrent.ExecutionException;

import com.football.organiser.server.models.TeamMember;
import com.football.organiser.server.repository.TeamMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamMemberServiceImpl implements TeamMemberService
{
    @Autowired
    TeamMemberRepository teamMemberRepository;

    @Override
    public List<TeamMember> getAllTeamMembersInGivenTeam(final String teamName) throws ExecutionException, InterruptedException
    {
        return teamMemberRepository.getAllTeamMembersInGivenTeam(teamName);
    }
}
