package com.football.organiser.server.services;

import com.football.organiser.server.models.TeamInfoInUser;
import com.football.organiser.server.models.User;
import com.football.organiser.server.repository.UserRepository;
import com.google.cloud.firestore.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.concurrent.ExecutionException;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmailIfExits(String email) throws ExecutionException, InterruptedException {
        return userRepository.getUserByEmailIfExits(email.toLowerCase(Locale.ROOT));
    }

    @Override
    public User addNewUser(User user) throws ExecutionException, InterruptedException {
        return userRepository.addNewUser(user);
    }

    @Override
    public WriteResult addTeamNameToUser(TeamInfoInUser info) throws ExecutionException, InterruptedException {
        return userRepository.addTeamNameToUser(info);
    }

    @Override
    public WriteResult removeTeamNameFromUser(TeamInfoInUser info) throws ExecutionException, InterruptedException {
        return userRepository.removeTeamNameFromUser(info);
    }
}
