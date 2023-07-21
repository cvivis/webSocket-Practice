package com.cvivis.websocketprac.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//
//    private final SocketTextHandler socketHandler;
//
//    public WebSocketConfig(SocketTextHandler socketHandler) {
//        this.socketHandler = socketHandler;
//    }
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//    registry.addHandler(socketHandler,"ws/chat") // handShake될 path설정
//            .setAllowedOrigins("*");// cors
////            .setAllowedOriginPatterns("http://*:8080", "http://*.*.*.*:8080");
////            .withSockJS(); // SockJs 라이브러리로 모든 브라우저 호환
//    }
//
//
////    @Bean
////    WebMvcConfigurer corsConfig() {
////        return new WebMvcConfigurer() {
////
////            @Override
////            public void addCorsMappings(CorsRegistry registry) {
////                registry.addMapping("/ws/**")
////                        .allowedMethods("GET", "POST", "PUT", "DELETE")
////                        .allowedHeaders("*")
////                        .allowCredentials(true);
//////                        .allowedOrigins(url);
////            }
////        };
////    }
//
//}

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //sockJs 클라이언트가 Websocket 핸드셰이크를 하기 위해 연결할 endpoint를 지정할 수 있다.
        registry.addEndpoint("/ws/chat")
                .setAllowedOriginPatterns("*");
//                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.enableSimpleBroker("/chat" , "/participants");
        registry.enableSimpleBroker("/sub");
//        registry.setUserDestinationPrefix("/pub");
        registry.setApplicationDestinationPrefixes("/pub"); // mapping 클래스 명시

    }
}
