package com.football.organiser.server.repository;

import com.football.organiser.server.database.FirestoreDatabase;
import com.football.organiser.server.models.Team;
import com.football.organiser.server.models.TeamMember;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class TeamRepository {

    @Autowired
    FirestoreDatabase firestoreDatabase;

    public Map<String, Object> createTeam(final Team team) throws ExecutionException, InterruptedException {

        // Add document data  with id "team.getTeamName()
        Map<String, Object> teamData = new HashMap<>();
        teamData.put("teamName", team.getTeamName());
        teamData.put("country", team.getCountry());
        teamData.put("teamCaptain", team.getTeamCaptain());
        teamData.put("uuid", team.getUuid());

        // I can put team.getTeamName() as an argument for .document() to make the teams document name as the team name
        // without it, a uid will be automatically generated
        DocumentReference createGroupCollection = firestoreDatabase.db.collection("teams").document();

        //asynchronously write data
        ApiFuture<WriteResult> populateCreatedGroupCollection = createGroupCollection.set(teamData);

        // result.get() blocks on response
        populateCreatedGroupCollection.get();

        Map<String, Object> createdTeam = new HashMap<>();
        createdTeam.put("teamName", team.getTeamName());
        createdTeam.put("country", team.getCountry());
        teamData.put("teamCaptain", team.getTeamCaptain());
        teamData.put("uuid", team.getUuid());

        return createdTeam;
    }

    public Map<String, Object> addPlayersToGroup(final TeamMember teamMember) throws ExecutionException, InterruptedException {

        // Add document data
        Map<String, Object> teamMemberData = new HashMap<>();
        teamMemberData.put(teamMember.getTeamMemberName(), teamMember);

        Map<String, Object> teamMemberField = new HashMap<>();
        teamMemberField.put("teamMembers", teamMemberData);

        DocumentReference createGroupCollection = firestoreDatabase.db.collection("teams").document(teamMember.getTeamName()).collection("teamMembers").document();

        //asynchronously write data
        ApiFuture<WriteResult> populateCreatedGroupCollection = createGroupCollection.set(teamMemberData);

        // result.get() blocks on response
        populateCreatedGroupCollection.get();

        Map<String, Object> addedTeamMember = new HashMap<>();
        addedTeamMember.put("addedTeamMember", teamMember.toString());
        addedTeamMember.put("addedToThisTeam", teamMember.getTeamName());

        return addedTeamMember;
    }

    public Map<String, Object> getAllTeams() throws ExecutionException, InterruptedException {

        Map<String, Object> allTeams = new HashMap<>();

        ApiFuture<QuerySnapshot> query = firestoreDatabase.db.collection("teams").get();

        List<QueryDocumentSnapshot> documents = query.get().getDocuments();

        for (DocumentSnapshot document : documents) {
            allTeams.put(document.getId(), document.toObject(Team.class));
            System.out.println(document.getId() + " => " + document.toObject(Team.class));
        }

        return allTeams;
    }
}
