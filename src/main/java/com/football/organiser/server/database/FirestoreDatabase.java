package com.football.organiser.server.database;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class FirestoreDatabase {

    public Firestore db;

    public FirestoreDatabase() throws IOException {
        InputStream serviceAccount = new FileInputStream("src/main/resources/fireStoreCred.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(options);
        this.db = FirestoreClient.getFirestore();
    }

}
