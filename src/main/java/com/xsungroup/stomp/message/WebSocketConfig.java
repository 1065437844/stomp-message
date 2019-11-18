package com.xsungroup.stomp.message;

import com.xsungroup.stomp.message.common.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.security.Principal;
import java.util.UUID;

/**
 * @author 梁建军
 * 创建日期： 2019/9/25
 * 创建时间： 19:39
 * @version 1.0
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(StompProperties.class)
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private static final Logger log = LoggerFactory.getLogger(WebSocketConfig.class);

    @Autowired
    private StompProperties stompProperties;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp").setAllowedOrigins("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableStompBrokerRelay("/topic", "/queue", "/exchange/amq.direct")
                .setUserDestinationBroadcast("/topic/unresolved-user-destination")
                .setUserRegistryBroadcast("/topic/simp-user-registry")
                .setRelayHost(stompProperties.getRelayHost())
                .setRelayPort(stompProperties.getRelayPort())
                .setClientLogin(stompProperties.getClientLogin())
                .setClientPasscode(stompProperties.getClientPasscode())
                .setSystemLogin(stompProperties.getSystemLogin())
                .setSystemPasscode(stompProperties.getSystemPasscode());
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor =
                        MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                if (accessor == null) {
                    throw new RuntimeException("");
                }
                final StompCommand command = accessor.getCommand();
                switch (accessor.getMessageType()) {
                    case HEARTBEAT:
                        return message;
                }
                if (command == null) {
                    throw new RuntimeException("");
                }
                switch (command) {
                    case CONNECT:

                        final String userId = accessor.getLogin();
                        Principal principal;
                        if (userId == null) {
                            principal = new UserPrincipal(UUID.randomUUID().toString(), true);
                        } else {
                            principal = new UserPrincipal(userId);
                        }
                        accessor.setUser(principal);
                    case SUBSCRIBE:
                        break;
                }
                return message;
            }
        });
    }
}
