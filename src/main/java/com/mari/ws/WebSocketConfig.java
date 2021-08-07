package com.mari.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //어플리케이션의 모든 url의 prefix로 app을 붙일것이다.
        //따라서 /app/hello로 들어오는 메시지들 받을수있다
        registry.setApplicationDestinationPrefixes("/app");

        //topic으로 시작하는 url의 구독자들에게 모두 응답 보낼것이다
        registry.enableSimpleBroker("/topic");


    }

    //핸드셰이크를 하기위해 설정할 웹소켓 엔드포인트 설정??
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    
    }

}
