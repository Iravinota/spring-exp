package com.ws.exp.spring.sockjs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.concurrent.TimeUnit;

/**
 * MacroHandler
 *
 * @author Eric at 2020-01-19_14:10
 */
public class MacroHandler extends AbstractWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(MacroHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("Received websocket message: " + message.getPayload());
        TimeUnit.SECONDS.sleep(2);
        session.sendMessage(new TextMessage("Polo!"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("Connection established");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("Connection closed. Status: " + status);
    }
}
