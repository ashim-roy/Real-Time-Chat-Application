package com.WebSoket.Chat.model;

/**
 * shuvrapatra :- 28-12-23
 */

public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;


    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}

/*
4. ChatMessage Class:
A simple Java class representing a chat message. It has fields for message type (CHAT, JOIN, LEAVE), content, and sender. The class also has getter and setter methods.

Summary of Flow:
Application Startup: The main method in ChatApplication starts the Spring Boot application.

WebSocket Configuration: The ChatConfig class configures WebSocket endpoints and message brokers.

WebSocket Controller: The ChatController class defines methods to handle WebSocket messages. Messages sent to "/chat.sendMessage" and "/chat.addUser" are processed accordingly.

Message Model: The ChatMessage class defines the structure of chat messages.

This application allows clients to connect to the "/ws" endpoint, send messages with types "CHAT", "JOIN", or "LEAVE" to the server,
and receive responses through the "/topic/public" destination. The ChatController processes these messages and broadcasts them to all
connected clients using the configured message broker. The ChatMessage class encapsulates the structure of the chat messages.
 */