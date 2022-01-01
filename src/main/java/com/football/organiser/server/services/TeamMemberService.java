package com.football.organiser.server.services;

import java.util.*;
import java.util.concurrent.ExecutionException;

import com.football.organiser.server.models.TeamMember;

public interface TeamMemberService
{
    List<TeamMember>  getAllTeamMembersInGivenTeam(final String teamName) throws ExecutionException, InterruptedException;
}
