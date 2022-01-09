package com.football.organiser.server.controller;

import com.football.organiser.server.database.FirestoreDatabase;
import com.football.organiser.server.models.Team;
import com.football.organiser.server.models.TeamMember;
import com.football.organiser.server.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    FirestoreDatabase firestoreDatabase;

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
        return teamService.addPlayersToTeam(teamMember);
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
        return teamService.getAllUserJoinedTeams(teamNamesList);
    }

    @GetMapping("/getTeamByName/{teamName}")
    public Team getTeamByName(@PathVariable final String teamName) throws ExecutionException, InterruptedException {
        return teamService.getTeamByName(teamName.toLowerCase(Locale.ROOT));
    }
}
