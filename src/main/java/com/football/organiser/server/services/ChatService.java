package com.football.organiser.server.services;

import com.football.organiser.server.models.Chat;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ChatService {
    boolean sendText(Chat chat);
    List<Chat> returnAll();
    List<Chat> getChatByGroupName(String group) throws ExecutionException, InterruptedException;
    boolean deleteText(final int id);
    boolean createGroup(final Chat groupName) throws ExecutionException, InterruptedException;
}
