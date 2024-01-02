follow this doc <kbd>press</kbd> : https://www.callicoder.com/spring-boot-websocket-chat-example/

1. ChatApplication Class:
   This is the entry point of the Spring Boot application. It is annotated with @SpringBootApplication, indicating that it's a Spring Boot application. The main method is the starting point of the application, and it uses SpringApplication.run(ChatApplication.class, args); to bootstrap the Spring application.

2. ChatConfig Class:
   This class is annotated with @Configuration and @EnableWebSocketMessageBroker. It configures the WebSocket support in the application.

@Configuration: Indicates that this class defines one or more @Bean methods and should be processed by the Spring container to generate bean definitions.

@EnableWebSocketMessageBroker: Enables WebSocket message handling, backed by a message broker.

The class implements WebSocketMessageBrokerConfigurer and overrides two methods:

registerStompEndpoints(StompEndpointRegistry registry): Configures the endpoint for the WebSocket communication. In this case, it registers an endpoint "/ws" and enables SockJS (a WebSocket emulation for browsers that don't support WebSocket directly).

configureMessageBroker(MessageBrokerRegistry registry): Configures the message broker. It sets the application destination prefix to "/app" and enables a simple in-memory broker with the destination prefix "/topic". This means that messages sent to destinations prefixed with "/topic" will be broadcasted to all connected clients.

3. ChatController Class:
   This is a Spring MVC controller for handling WebSocket messages.

@RestController: Indicates that this class is a Spring MVC controller, and its methods return domain objects instead of view names.
Two methods are defined:

sendMessage(@Payload ChatMessage chatMessage): Handles messages with the mapping "/chat.sendMessage". It is annotated with @MessageMapping to handle STOMP messages, and @SendTo("/topic/public") to send the response to all subscribers of the "/topic/public" destination. It echoes the received ChatMessage back to all connected clients.

addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor): Handles messages with the mapping "/chat.addUser". It is similar to sendMessage but also stores the username in the WebSocket session using SimpMessageHeaderAccessor.

4. ChatMessage Class:
   A simple Java class representing a chat message. It has fields for message type (CHAT, JOIN, LEAVE), content, and sender. The class also has getter and setter methods.

Summary of Flow:
Application Startup: The main method in ChatApplication starts the Spring Boot application.

WebSocket Configuration: The ChatConfig class configures WebSocket endpoints and message brokers.

WebSocket Controller: The ChatController class defines methods to handle WebSocket messages. Messages sent to "/chat.sendMessage" and "/chat.addUser" are processed accordingly.

Message Model: The ChatMessage class defines the structure of chat messages.

This application allows clients to connect to the "/ws" endpoint, send messages with types "CHAT", "JOIN", or "LEAVE" to the server, and receive responses through the "/topic/public" destination. The ChatController processes these messages and broadcasts them to all connected clients using the configured message broker. The ChatMessage class encapsulates the structure of the chat messages.






