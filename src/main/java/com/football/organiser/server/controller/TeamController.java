package com.football.organiser.server.controller;

import com.football.organiser.server.models.Chat;
import com.football.organiser.server.models.Team;
import com.football.organiser.server.services.ChatService;
import com.football.organiser.server.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping
    public Team createTeam(@RequestBody final Team teamDetails) throws ExecutionException, InterruptedException {
        System.out.println("post has gone through");
        System.out.println("this is the team details" + teamDetails.toString());
        teamService.createTeam(teamDetails);
        return teamDetails;
    }
}
