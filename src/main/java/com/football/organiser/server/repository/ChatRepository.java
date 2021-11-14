package com.football.organiser.server.repository;

import com.football.organiser.server.database.FirestoreDatabase;
import com.football.organiser.server.models.Chat;
import com.football.organiser.server.models.TeamMember;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ChatRepository {

    @Autowired
    FirestoreDatabase firestoreDatabase;


    public boolean sendText(final Chat chat){
        return false;
    }

    public List<Chat> getChatByGroupName(String group) throws ExecutionException, InterruptedException {
        System.out.println("this is the group name: " + group);
        ApiFuture<QuerySnapshot> queryAllTeamMembers = firestoreDatabase.db.collection("teams").document(group).collection("messages").get();
        List<QueryDocumentSnapshot> chatMessages = queryAllTeamMembers.get().getDocuments();

        final List<Chat> chatStream = chatMessages.stream().map(a -> a.toObject(Chat.class)).collect(Collectors.toList());

        System.out.println(chatStream.get(0).getText());

        return null;
    }

}



//        return teamMemberDocuments.stream()
//                .map(a -> a.toObject(TeamMember.class))
//                .collect(Collectors.groupingBy(TeamMember::getTeamName));
