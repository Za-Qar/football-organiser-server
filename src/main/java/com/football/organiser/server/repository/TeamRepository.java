package com.football.organiser.server.repository;

import com.football.organiser.server.database.FirestoreDatabase;
import com.football.organiser.server.exceptions.SafeGuardException;
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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class TeamRepository {

    @Autowired
    FirestoreDatabase firestoreDatabase;

    public Map<String, Object> createTeam(final Team team) throws ExecutionException, InterruptedException {

        // Add document data  with id "team.getTeamName()
        Map<String, Object> teamData = new HashMap<>();
        teamData.put("country", team.getCountry());
        teamData.put("teamCaptain", team.getTeamCaptain());
        teamData.put("teamCaptainEmail", team.getTeamCaptainEmail());
        teamData.put("teamCaptainPhotoUrl", team.getTeamCaptainPhotoUrl());
        teamData.put("teamName", team.getTeamName());
        teamData.put("uuid", team.getUid());
        teamData.put("groupImage", team.getGroupImage());
        teamData.put("isPublic", team.getPublic());
        teamData.put("gameType", team.getGameType());
        teamData.put("description", team.getDescription());

        // I can put team.getTeamName() as an argument for .document() to make the teams document name as the team name
        // without it, a uid will be automatically generated
        DocumentReference createGroupCollection = firestoreDatabase.db.collection("teams").document(team.getTeamName());

        //asynchronously write data
        ApiFuture<WriteResult> populateCreatedGroupCollection = createGroupCollection.set(teamData);

        // result.get() blocks on response
        populateCreatedGroupCollection.get();

        return teamData;
    }

    public Map<String, Object> addPlayersToTeam(final TeamMember teamMember) throws ExecutionException, InterruptedException {

        System.out.println("this is teamMember: " + teamMember);

        // data model 1, teams members are sub collections
        // Add document data
        Map<String, Object> teamMemberData = new HashMap<>();
        teamMemberData.put("joinedTimeStamp", teamMember.getJoinedTimeStamp());
        teamMemberData.put("phoneNumber", teamMember.getPhoneNumber());
        teamMemberData.put("photoUrl", teamMember.getPhotoUrl());
        teamMemberData.put("teamMemberName", teamMember.getTeamMemberName());
        teamMemberData.put("teamMemberEmail", teamMember.getTeamMemberEmail());
        teamMemberData.put("teamNameToJoin", teamMember.getTeamNameToJoin());
        teamMemberData.put("uid", teamMember.getUid());
        teamMemberData.put("gender", teamMember.getGender());

        DocumentReference createGroupCollection = firestoreDatabase.db.collection("teams").document(teamMember.getTeamNameToJoin()).collection("teamMembers").document();

        //asynchronously write data
        ApiFuture<WriteResult> populateCreatedGroupCollection = createGroupCollection.set(teamMemberData);

        // result.get() blocks on response
        populateCreatedGroupCollection.get();

        return teamMemberData;
    }

    public List<Team> getAllTeams() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> queryAllTeams = firestoreDatabase.db.collection("teams").get();
        List<QueryDocumentSnapshot> allTeamsDocuments = queryAllTeams.get().getDocuments();

        return allTeamsDocuments.stream()
                .map(a -> a.toObject(Team.class))
                .collect(Collectors.toList());
    }

    public Map<String, Object> getTeamById(final String id, final Team team, final TeamMember teamMember){


        Map<String, Object> teamDataToUpdate = new HashMap<>();
        teamDataToUpdate.put("teamName", team.getTeamName());
        teamDataToUpdate.put("country", team.getCountry());
        teamDataToUpdate.put("teamCaptain", team.getTeamCaptain());


        firestoreDatabase.db.collection("teams").document("5I5bKW4EIMQ2riQvXqcv").update(teamDataToUpdate);

        return teamDataToUpdate;
    }

    public static <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(keys::get, values::get));
    }
}
