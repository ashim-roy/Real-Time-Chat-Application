package com.WebSoket.Chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class ChatConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");   // Enables a simple in-memory broker
    }

}
/*
2. ChatConfig Class:
This class is annotated with @Configuration and @EnableWebSocketMessageBroker. It configures the WebSocket support in the application.

@Configuration: Indicates that this class defines one or more @Bean methods and should be processed by the Spring container to generate bean definitions.

@EnableWebSocketMessageBroker: Enables WebSocket message handling, backed by a message broker.

The class implements WebSocketMessageBrokerConfigurer and overrides two methods:

registerStompEndpoints(StompEndpointRegistry registry): Configures the endpoint for the WebSocket communication. In this case, it registers an endpoint "/ws" and enables SockJS (a WebSocket emulation for browsers that don't support WebSocket directly).

configureMessageBroker(MessageBrokerRegistry registry): Configures the message broker. It sets the application destination prefix to "/app" and enables a
simple in-memory broker with the destination prefix "/topic". This means that messages sent to destinations prefixed with "/topic" will be broadcasted to
all connected clients.
 */