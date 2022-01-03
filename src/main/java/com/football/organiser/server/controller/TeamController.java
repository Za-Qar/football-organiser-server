package com.football.organiser.server.controller;

import com.football.organiser.server.models.Team;
import com.football.organiser.server.models.TeamMember;
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

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/createTeam")
    public Team createTeam(@RequestBody final Team teamDetails) throws ExecutionException, InterruptedException {
        teamService.createTeam(teamDetails);
        return teamDetails;
    }

    @PostMapping("/addPlayerToTeam")
    public Map<String, Object> addPlayerToTeam(@RequestBody final TeamMember teamMember) throws ExecutionException, InterruptedException {
        return teamService.addPlayersToGroup(teamMember);
    }

    @GetMapping
    public List<Team> getAllTeams() throws ExecutionException, InterruptedException {
        return teamService.getAllTeams();
    }

    @GetMapping("/{teamMemberUid}")
    public List<Team> getFilterUserJoinedTeams(@PathVariable final String teamMemberUid) throws ExecutionException, InterruptedException {
        return teamService.getFilterUserJoinedTeams(teamMemberUid);
    }

    @PostMapping("/joinedTeams")
    public List<Team> getAllUserJoinedTeams(@RequestBody final List<String> teamNamesList) throws ExecutionException, InterruptedException {
        System.out.println("these are team names: " + teamNamesList.get(0));
        return teamService.getAllUserJoinedTeams(teamNamesList);
    }

}
