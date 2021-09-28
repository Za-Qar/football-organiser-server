package com.football.organiser.server.services;

import java.util.*;
import java.util.concurrent.ExecutionException;

import com.football.organiser.server.models.TeamMember;

public interface TeamMemberService
{
    Map<String, List<TeamMember>> getAllTeamMembers() throws ExecutionException, InterruptedException;
}
