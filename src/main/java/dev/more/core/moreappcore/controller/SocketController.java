package dev.more.core.moreappcore.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SocketController {
    private long chatId = 123;

    @MessageMapping("/hello-msg-mapping")
    @SendTo("/topic/greetings")
    public String greeting(String name) {
        return "Hello, " + name + "!";
    }


    @MessageMapping("/create-chat")
    @SendTo("/topic/create/chats")
    public Long createChat(String name) {
        return chatId;
    }
}