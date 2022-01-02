package com.football.organiser.server.services;

import com.football.organiser.server.models.User;

import java.util.concurrent.ExecutionException;

public interface UserService {
    User getUserByEmailIfExits(final String email) throws ExecutionException, InterruptedException;
    User addNewUser(final User user) throws ExecutionException, InterruptedException;
}
