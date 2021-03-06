package com.football.organiser.server.controller;

import com.football.organiser.server.models.Chat;
import com.football.organiser.server.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/chat")
public class ChatController {

    public ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping(path = "/{group}")
    public List<Chat> getChatByGroup(@PathVariable("group") final String group) throws ExecutionException, InterruptedException {
        return chatService.getChatByGroupName(group);
    }

    @PostMapping
    public Chat createGroup(@RequestBody final Chat groupName) throws ExecutionException, InterruptedException {
        chatService.createGroup(groupName);
        return groupName;
    }
}
