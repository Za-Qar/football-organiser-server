package com.football.organiser.server.controller;

import com.football.organiser.server.database.FirestoreDatabase;
import com.football.organiser.server.models.TeamInfoInUser;
import com.football.organiser.server.models.User;
import com.football.organiser.server.services.UserService;

import com.google.cloud.firestore.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {

    public UserService userService;

    @Autowired
    FirestoreDatabase firestoreDatabase;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{email}")
    public User getUserByEmailIfExits(@PathVariable("email") final String email) throws ExecutionException, InterruptedException {
        return userService.getUserByEmailIfExits(email.toLowerCase(Locale.ROOT));
    }

    @PostMapping(path = "/createUser")
    public User addNewUser(@RequestBody final User user) throws ExecutionException, InterruptedException {
        return userService.addNewUser(user);
    }

    @PatchMapping(path = "/patchUser/addTeamToUser")
    public WriteResult addTeamNameToUser(@RequestBody final TeamInfoInUser info) throws ExecutionException, InterruptedException {
        return userService.addTeamNameToUser(info);
    }

    @PatchMapping(path = "/patchUser/removeTeamFromUser")
    public WriteResult removeTeamNameFromUser(@RequestBody final TeamInfoInUser info) throws ExecutionException, InterruptedException {
        return userService.removeTeamNameFromUser(info);
    }
}

