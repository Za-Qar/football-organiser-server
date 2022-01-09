package com.football.organiser.server.repository;

import com.football.organiser.server.database.FirestoreDatabase;
import com.football.organiser.server.models.Team;
import com.football.organiser.server.models.TeamMember;
import com.football.organiser.server.models.UserInfoInTeam;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

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

        // data model 1, teams members are sub collections
        // Add document data
        Map<String, Object> teamMemberData = new HashMap<>();
        teamMemberData.put("joinedTimeStamp", teamMember.getJoinedTimeStamp());
        teamMemberData.put("phoneNumber", Long.parseLong(String.valueOf(teamMember.getPhoneNumber())));
        teamMemberData.put("photoUrl", teamMember.getPhotoUrl());
        teamMemberData.put("teamMemberName", teamMember.getTeamMemberName().toLowerCase(Locale.ROOT));
        teamMemberData.put("teamMemberEmail", teamMember.getTeamMemberEmail().toLowerCase(Locale.ROOT));
        teamMemberData.put("teamNameToJoin", teamMember.getTeamNameToJoin());
        teamMemberData.put("uuid", teamMember.getUuid());
        teamMemberData.put("gender", teamMember.getGender());

        DocumentReference createGroupCollection = firestoreDatabase.db.collection("teams").document(teamMember.getTeamNameToJoin().toLowerCase(Locale.ROOT)).collection("teamMembers").document();

        //asynchronously write data
        ApiFuture<WriteResult> populateCreatedGroupCollection = createGroupCollection.set(teamMemberData);

        // result.get() blocks on response
        populateCreatedGroupCollection.get();

        // add UserInfoHere
        UserInfoInTeam userInfoInTeam = new UserInfoInTeam(teamMember.getPhotoUrl(), teamMember.getTeamMemberName(), teamMember.getUuid());
        this.addUserToTeam(userInfoInTeam, teamMember.getTeamNameToJoin());

        return teamMemberData;
    }

    public List<Team> getAllTeams() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> queryAllTeams = firestoreDatabase.db.collection("teams").get();
        List<QueryDocumentSnapshot> allTeamsDocuments = queryAllTeams.get().getDocuments();

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
        if(getTeam.get().exists()){
            return getTeam.get().toObject(Team.class);
        } else {
            return new Team();
        }

    }

    private TeamMember getFilterUserJoinedTeamMembers(final String teamMemberUid, final String teamName) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> createGroupCollection = firestoreDatabase.db.collection("teams").document(teamName).collection("teamMembers").get();
        List<QueryDocumentSnapshot> allTeamsDocuments = createGroupCollection.get().getDocuments();

        return allTeamsDocuments.stream()
                .map(a -> a.toObject(TeamMember.class))
                .filter(a -> a.getUuid().equals(teamMemberUid))
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

    private WriteResult addUserToTeam(final UserInfoInTeam userInfoInTeam, String teamName) throws ExecutionException, InterruptedException {
        DocumentReference teamDocRef = firestoreDatabase.db.collection("teams").document(teamName.toLowerCase(Locale.ROOT));
        ApiFuture<WriteResult> arrayUnion = teamDocRef.update("teamMemberInfo",
                FieldValue.arrayUnion(userInfoInTeam));
        return arrayUnion.get();
    }
}
