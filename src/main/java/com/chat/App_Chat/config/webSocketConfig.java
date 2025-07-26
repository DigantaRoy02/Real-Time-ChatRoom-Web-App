package com.chat.App_Chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
@Configuration
@EnableWebSocketMessageBroker
public class webSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker("/topic"); //“Any message sent to a destination that starts with /topic/ should be handled by the built-in message broker and broadcast to all subscribed clients.”
    registry.setApplicationDestinationPrefixes("/app");  //“Whenever a STOMP message is sent to a destination
                     // starting with /app, don't send it to the broker —
        // instead, map it to a controller method annotated with @MessageMapping.”
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat") // used for connection bw the backend &client
                .setAllowedOrigins("http://localhost:8080").withSockJS();
    }
}
