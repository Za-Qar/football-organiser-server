package com.football.organiser.server.controller;

import com.football.organiser.server.models.Chat;
import com.football.organiser.server.models.Team;
import com.football.organiser.server.models.TeamMember;
import com.football.organiser.server.services.ChatService;
import com.football.organiser.server.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/teams")
public class TeamController {

    public TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/createTeam")
    public Team createTeam(@RequestBody final Team teamDetails) throws ExecutionException, InterruptedException {
        System.out.println("createTeam post request has gone through");
        teamService.createTeam(teamDetails);
        return teamDetails;
    }

    @PostMapping("/addPlayerToTeam")
    public Map<String, Object> addPlayerToTeam(@RequestBody final TeamMember teamMember) throws ExecutionException, InterruptedException {
        System.out.println("addplayertoteam post has gone through");
        return teamService.addPlayersToGroup(teamMember);
    }

    @GetMapping
    public Map<String, Object> getAllTeams() throws ExecutionException, InterruptedException {
        return teamService.getAllTeams();
    }
}
