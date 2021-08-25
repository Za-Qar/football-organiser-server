package com.football.organiser.server.repository;

import com.football.organiser.server.models.Chat;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Internal;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class ChatRepository {

//    Firestore db;
//
//    public ChatRepository() throws IOException {
//        InputStream serviceAccount = new FileInputStream("src/main/resources/fireStoreCred.json");
//        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
//        FirebaseOptions options = FirebaseOptions.builder()
//                .setCredentials(credentials)
//                .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
//                .build();
//        FirebaseApp.initializeApp(options);
//        this.db = FirestoreClient.getFirestore();
//    }


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
