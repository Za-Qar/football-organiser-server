package com.football.organiser.server.controller;

import com.football.organiser.server.models.TeamMember;
import com.football.organiser.server.services.TeamMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/teamMembers")
public class TeamMembersController
{
    public TeamMemberService teamMemberService;

    @Autowired
    public TeamMembersController(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @GetMapping("/{teamName}")
    public List<TeamMember>  getAllTeamMembersInGivenTeam(@PathVariable("teamName") final String teamName) throws ExecutionException, InterruptedException {
        return teamMemberService.getAllTeamMembersInGivenTeam(teamName.toLowerCase(Locale.ROOT));
    }
}
