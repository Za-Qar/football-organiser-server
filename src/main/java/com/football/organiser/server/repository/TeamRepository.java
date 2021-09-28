package com.football.organiser.server.repository;

import com.football.organiser.server.database.FirestoreDatabase;
import com.football.organiser.server.models.Team;
import com.football.organiser.server.models.TeamMember;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

        // data model 1, teams members are sub collections
        // Add document data
        Map<String, Object> teamMemberData = new HashMap<>();
        teamMemberData.put("teamMemberName", teamMember.getTeamName());
        teamMemberData.put("joinedTimeStamp", teamMember.getJoinedTimeStamp());
        teamMemberData.put("photoUrl", teamMember.getPhotoUrl());
        teamMemberData.put("uuid", teamMember.getUuid());
        teamMemberData.put("location", teamMember.getLocation());
        teamMemberData.put("phoneNumber", teamMember.getPhoneNumber());
        teamMemberData.put("teamName", teamMember.getTeamName());


        DocumentReference createGroupCollection = firestoreDatabase.db.collection("teams").document(teamMember.getTeamName()).collection("teamMembers").document();

        //asynchronously write data
        ApiFuture<WriteResult> populateCreatedGroupCollection = createGroupCollection.set(teamMemberData);

        // result.get() blocks on response
        populateCreatedGroupCollection.get();

        return teamMemberData;
    }

    public Map<String, List<TeamMember>> getAllTeamMembersMap() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> queryAllTeamMembers = firestoreDatabase.db.collection("teams").document("Zaid's group").collection("teamMembers").get();
        List<QueryDocumentSnapshot> teamMemberDocuments = queryAllTeamMembers.get().getDocuments();

        return teamMemberDocuments.stream()
                .map(a -> a.toObject(TeamMember.class))
                .collect(Collectors.groupingBy(TeamMember::getTeamName));
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
