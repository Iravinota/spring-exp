package com.ws.exp.spring.stomp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocketConfiguration
 *
 * @author Eric at 2020-01-20_14:12
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    // 为/stompwebsockt路径启用SockJS功能。注册/stompwebsocket为STOMP端点。index.html中要向这个地址发送消息
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stompwebsocket").withSockJS();
    }

    // 消息代理：处理/queue和/topic为前缀的消息。发往应用程序的消息带有/app前缀
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/queue", "/topic");    // 内存代理
        // 所有以/app开头的消息都将会路由到带有@MessageMapping注解的方法中
        registry.setApplicationDestinationPrefixes("/app");
    }
}
