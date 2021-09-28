package com.football.organiser.server.controller;

import com.football.organiser.server.models.TeamMember;
import com.football.organiser.server.services.TeamMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public Map<String, List<TeamMember>> getAllTeamMembers() throws ExecutionException, InterruptedException {
        return teamMemberService.getAllTeamMembers();
    }
}
