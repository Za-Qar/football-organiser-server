package com.football.organiser.server.repository;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import com.football.organiser.server.database.FirestoreDatabase;
import com.football.organiser.server.models.TeamMember;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamMemberRepository
{
    @Autowired
    FirestoreDatabase firestoreDatabase;

    public Map<String, List<TeamMember>> getAllTeamMembersMap() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> queryAllTeamMembers = firestoreDatabase.db.collection("teams").document("Zaid's group").collection("teamMembers").get();
        List<QueryDocumentSnapshot> teamMemberDocuments = queryAllTeamMembers.get().getDocuments();

        return teamMemberDocuments.stream()
                .map(a -> a.toObject(TeamMember.class))
                .collect(Collectors.groupingBy(TeamMember::getTeamNameToJoin));
    }
}
