package com.football.organiser.server.controller;

import com.football.organiser.server.models.Chat;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/game")
public class GameController {

    public GameController() {}

    @PostMapping
    public Chat createGroup(@RequestBody final Chat groupName) throws ExecutionException, InterruptedException {
        System.out.println("post has gone through");
        System.out.println("this is the group name" + groupName.toString());
        chatService.createGroup(groupName);
        return groupName;
    }
}
