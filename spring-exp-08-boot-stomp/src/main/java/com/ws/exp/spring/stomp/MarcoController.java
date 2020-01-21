package com.ws.exp.spring.stomp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * MarcoController
 *
 * @author Eric at 2020-01-20_15:06
 */
@Controller
public class MarcoController {
    private static final Logger logger = LoggerFactory.getLogger(MarcoController.class);

    private SimpMessagingTemplate simpMessagingTemplate;

    // spring boot自动组装的bean
    @Autowired
    public void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    // 处理发往/app/marco的消息。/app是隐含的，在WebSocketConfiguration.java中定义
    @MessageMapping("/marco")
    @SendTo("/topic/shout") // 不添加这个注解时，返回消息会发送到/topic+@MessageMapping相同的地址，即/topic/marco
    public String handleShout(String incoming) {
        logger.info("Received message: " + incoming);
        return "Polo!";
    }

    // 使用SimpMessagingTemplate随时随地返回消息
    @MessageMapping("/marco2")
    public void handleMessage(String msg) {
        logger.info("Received message on /app/marco2: " + msg);
        simpMessagingTemplate.convertAndSend("/topic/shout", "Polo2!");
    }
}
