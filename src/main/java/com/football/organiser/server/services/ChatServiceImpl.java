package com.football.organiser.server.services;

import com.football.organiser.server.models.Chat;
import com.football.organiser.server.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class ChatServiceImpl implements ChatService {

    @Autowired
    private final ChatRepository chatRepository;

    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public boolean sendText(final Chat chat) {
        return chatRepository.sendText(chat);
    }

    @Override
    public List<Chat> returnAll() {
        return null;
    }

    @Override
    public List<Chat> getChatByGroupName() {
        return chatRepository.getChatByGroupName();
    }

    @Override
    public boolean deleteText(final int id) {
        return false;
    }

    @Override
    public boolean createGroup(final Chat groupName) throws ExecutionException, InterruptedException {
        return false;
    }
}
