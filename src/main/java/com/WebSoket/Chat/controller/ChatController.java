package com.WebSoket.Chat.controller;

import com.WebSoket.Chat.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
/*
3. ChatController Class:
This is a Spring MVC controller for handling WebSocket messages.

@RestController: Indicates that this class is a Spring MVC controller, and its methods return domain objects instead of view names.
Two methods are defined:

sendMessage(@Payload ChatMessage chatMessage): Handles messages with the mapping "/chat.sendMessage". It is annotated with @MessageMapping
 to handle STOMP messages, and @SendTo("/topic/public") to send the response to all subscribers of the "/topic/public" destination. It echoes
 the received ChatMessage back to all connected clients.

addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor): Handles messages with the mapping "/chat.addUser".
It is similar to sendMessage but also stores the username in the WebSocket session using SimpMessageHeaderAccessor.
 */