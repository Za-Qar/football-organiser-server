package com.football.organiser.server.repository;

import com.football.organiser.server.database.FirestoreDatabase;
import com.football.organiser.server.models.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatRepository {

    @Autowired
    FirestoreDatabase firestoreDatabase;


    public boolean sendText(final Chat chat){
        return false;
    }

    public List<Chat> getChatByGroupName() {
        return null;
    }

//    public boolean createGroup() throws ExecutionException, InterruptedException {
//
//        // Add document data  with id "alovelace" using a hashmap
//        Map<String, Object> docData = new HashMap<>();
//        docData.put("bham", "league");
//        docData.put("data", "test");
//        docData.put("born", 1995);
//
//        Map<String, String> messageData = new HashMap<>();
//        messageData.put("1", "Hello");
//        messageData.put("2", "Sup");
//        messageData.put("3", "Yo");
//
//
//        System.out.println("step 1");
//        DocumentReference docRef = db.collection("groups").document("bham superleague");
//
//        DocumentReference messageRef = db.collection("groups").document("bham superleague").collection("messages").document("texts");
//
//
//        System.out.println("step 2");
//        //asynchronously write data
//        ApiFuture<WriteResult> docResult = docRef.set(docData);
//        ApiFuture<WriteResult> messageResult = messageRef.set(messageData);
//
//
//
//        System.out.println("step 4");
////         ...
////         result.get() blocks on response
//        System.out.println("Update time : " + docResult.get().getUpdateTime());
//        System.out.println("Update time : " + messageResult.get().getUpdateTime());
//
//        return true;
//    }
}
