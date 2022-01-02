package com.football.organiser.server.services;

import com.football.organiser.server.models.User;
import com.football.organiser.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRespository;

    public UserServiceImpl(final UserRepository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public User getUserByEmailIfExits(String email) throws ExecutionException, InterruptedException {
        return userRespository.getUserByEmailIfExits(email);
    }

    @Override
    public User addNewUser(User user) throws ExecutionException, InterruptedException {
        return userRespository.addNewUser(user);
    }
}
