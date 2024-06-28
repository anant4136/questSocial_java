package com.forum.forum.controller;

import com.forum.forum.entity.Message;
import com.forum.forum.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/messages")
@CrossOrigin("*")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping
    public Message createMessage(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam String content) {
        Message message = messageService.createMessage(senderId, receiverId, content);
        messagingTemplate.convertAndSend("/topic/messages", message);
        return message;
    }

    @GetMapping
    public List<Message> getMessages(@RequestParam Long senderId, @RequestParam Long receiverId) {
        return messageService.getMessages(senderId, receiverId);
    }
}
