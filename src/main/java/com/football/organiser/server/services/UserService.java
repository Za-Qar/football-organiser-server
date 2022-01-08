package com.football.organiser.server.services;

import com.football.organiser.server.models.TeamInfoInUser;
import com.football.organiser.server.models.User;
import com.google.cloud.firestore.WriteResult;

import java.util.concurrent.ExecutionException;

public interface UserService {
    User getUserByEmailIfExits(final String email) throws ExecutionException, InterruptedException;
    User addNewUser(final User user) throws ExecutionException, InterruptedException;
    WriteResult addTeamNameToUser(final TeamInfoInUser info) throws ExecutionException, InterruptedException;
    WriteResult removeTeamNameFromUser(final TeamInfoInUser info) throws ExecutionException, InterruptedException;
}
