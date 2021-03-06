package com.football.organiser.server.repository;

import com.football.organiser.server.database.FirestoreDatabase;
import com.football.organiser.server.models.TeamInfoInUser;
import com.football.organiser.server.models.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class UserRepository {

    @Autowired
    FirestoreDatabase firestoreDatabase;

    public User getUserByEmailIfExits(final String email) throws ExecutionException, InterruptedException {
        ApiFuture<DocumentSnapshot> queryUserDocs = firestoreDatabase.db.collection("users").document(email).get();
        DocumentSnapshot document = queryUserDocs.get();

        if (document.exists()) {
            User user = document.toObject(User.class);
            return user;
        } else {
            return new User();
        }
    }

    public User addNewUser(final User user) throws ExecutionException, InterruptedException {
        // Add document data  with id "team.getTeamName()
        Map<String, Object> userData = new HashMap<>();
        userData.put("name", user.getName());
        userData.put("email", user.getEmail().toLowerCase(Locale.ROOT));
        userData.put("uuid", user.getUuid());
        userData.put("photoUrl", user.getPhotoUrl());
        userData.put("teamsJoined", user.getTeamsJoined());
        userData.put("phoneNumber", user.getPhoneNumber());

        // I can put team.getTeamName() as an argument for .document() to make the teams document name as the team name
        // without it, a uid will be automatically generated
        DocumentReference createGroupCollection = firestoreDatabase.db.collection("users").document(user.getEmail());

        //asynchronously write data
        ApiFuture<WriteResult> populateCreatedGroupCollection = createGroupCollection.set(userData);

        // result.get() blocks on response
        populateCreatedGroupCollection.get();
        return user;
    }

    public WriteResult addTeamNameToUser(final TeamInfoInUser info) throws ExecutionException, InterruptedException {
        DocumentReference userDocRef = firestoreDatabase.db.collection("users").document(info.getEmail().toLowerCase(Locale.ROOT));
        ApiFuture<WriteResult> arrayUnion = userDocRef.update("teamsJoined",
                FieldValue.arrayUnion(info.getTeamName().toLowerCase(Locale.ROOT)));
        return arrayUnion.get();
    }

    public WriteResult removeTeamNameFromUser(final TeamInfoInUser info) throws ExecutionException, InterruptedException {
        DocumentReference userDocRef = firestoreDatabase.db.collection("users").document(info.getEmail().toLowerCase(Locale.ROOT));
        ApiFuture<WriteResult> arrayRm = userDocRef.update("teamsJoined",
                FieldValue.arrayRemove(info.getTeamName().toLowerCase(Locale.ROOT)));
        return arrayRm.get();
    }
}
