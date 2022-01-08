package com.football.organiser.server.repository;

import com.football.organiser.server.database.FirestoreDatabase;
import com.football.organiser.server.models.Team;
import com.football.organiser.server.models.TeamMember;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
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
        teamData.put("teamCaptainEmail", team.getTeamCaptainEmail().toLowerCase(Locale.ROOT));
        teamData.put("teamCaptainPhotoUrl", team.getTeamCaptainPhotoUrl());
        teamData.put("teamName", team.getTeamName().toLowerCase(Locale.ROOT));
        teamData.put("uuid", team.getUuid());
        teamData.put("groupImage", team.getGroupImage());
        teamData.put("isPublic", team.getIsPublic());
        teamData.put("gameType", team.getGameType());
        teamData.put("description", team.getDescription());
        teamData.put("teamMemberInfo", team.getTeamMemberInfo());

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

        System.out.println("player being added to team");
        System.out.println("this is teamMember.getTeamNameToJoin(): " + teamMember.getTeamNameToJoin());

        // data model 1, teams members are sub collections
        // Add document data
        Map<String, Object> teamMemberData = new HashMap<>();
        teamMemberData.put("joinedTimeStamp", teamMember.getJoinedTimeStamp());
        teamMemberData.put("phoneNumber", Long.parseLong(String.valueOf(teamMember.getPhoneNumber())));
        teamMemberData.put("photoUrl", teamMember.getPhotoUrl());
        teamMemberData.put("teamMemberName", teamMember.getTeamMemberName().toLowerCase(Locale.ROOT));
        teamMemberData.put("teamMemberEmail", teamMember.getTeamMemberEmail().toLowerCase(Locale.ROOT));
        teamMemberData.put("teamNameToJoin", teamMember.getTeamNameToJoin());
        teamMemberData.put("uid", teamMember.getUid());
        teamMemberData.put("gender", teamMember.getGender());

        DocumentReference createGroupCollection = firestoreDatabase.db.collection("teams").document(teamMember.getTeamNameToJoin().toLowerCase(Locale.ROOT)).collection("teamMembers").document();

        //asynchronously write data
        ApiFuture<WriteResult> populateCreatedGroupCollection = createGroupCollection.set(teamMemberData);

        // result.get() blocks on response
        populateCreatedGroupCollection.get();

        return teamMemberData;
    }

    public List<Team> getAllTeams() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> queryAllTeams = firestoreDatabase.db.collection("teams").get();
        List<QueryDocumentSnapshot> allTeamsDocuments = queryAllTeams.get().getDocuments();

//        this.getFilterUserJoinedTeams("b8II3O2z8ESsmKD9A5uXdwd1ejQ2");

        return allTeamsDocuments.stream()
                .map(a -> a.toObject(Team.class))
                .collect(Collectors.toList());
    }

    public List<Team> getFilterUserJoinedTeams(final String teamMemberUid) throws ExecutionException, InterruptedException {

        System.out.println("teamMemberUid: " + teamMemberUid);

        List<String> teamNames = this.getAllTeamNames();

        List<String> allTeamNames = new ArrayList<>();
        List<Team> allTeamJoinedByUser = new ArrayList<>();

        teamNames.forEach(teamName -> {
                try {
                   final TeamMember teamMember = this.getFilterUserJoinedTeamMembers(teamMemberUid, teamName);
                   if(teamMember != null){
                    allTeamNames.add(teamMember.getTeamNameToJoin());
                   }
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        );

        for(String teamName : allTeamNames){
            Team team = this.getTeamByName(teamName);
            allTeamJoinedByUser.add(team);
        }

        return allTeamJoinedByUser;
    }

    public List<Team> getAllUserJoinedTeams(final List<String> teamNames) throws ExecutionException, InterruptedException {

        List<Team> allTeamJoinedByUser = new ArrayList<>();

        teamNames.forEach(teamName -> {
                    try {
                        final Team team = this.getTeamByName(teamName.toLowerCase(Locale.ROOT));
                        if(team != null){
                            allTeamJoinedByUser.add(team);
                        }
                    } catch (ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        return allTeamJoinedByUser;
    }

    public Team getTeamByName(final String teamName) throws ExecutionException, InterruptedException {
        ApiFuture<DocumentSnapshot> getTeam = firestoreDatabase.db.collection("teams").document(teamName).get();
        return getTeam.get().toObject(Team.class);
    }

    private TeamMember getFilterUserJoinedTeamMembers(final String teamMemberUid, final String teamName) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> createGroupCollection = firestoreDatabase.db.collection("teams").document(teamName).collection("teamMembers").get();
        List<QueryDocumentSnapshot> allTeamsDocuments = createGroupCollection.get().getDocuments();

        // The following will also work to get the required object from a list
        // .filter(a -> Objects.equal(a.getUid(), "b8II3O2z8ESsmKD9A5uXdwd1ejQ2"))
        return allTeamsDocuments.stream()
                .map(a -> a.toObject(TeamMember.class))
                .filter(a -> a.getUid().equals(teamMemberUid))
                .findFirst()
                .orElse(null);
    }

    private List<String> getAllTeamNames() throws ExecutionException, InterruptedException {
        List<Team> getAllTeams = this.getAllTeams();

        return getAllTeams.stream()
                .map(Team::getTeamName)
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

    private static <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(keys::get, values::get));
    }
}
