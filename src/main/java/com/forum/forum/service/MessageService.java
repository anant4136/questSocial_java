package com.forum.forum.service;

import com.forum.forum.entity.Message;
import com.forum.forum.entity.User;
import com.forum.forum.repository.MessageRepository;
import com.forum.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public Message createMessage(Long senderId, Long receiverId, String content) {
        User sender = userRepository.findById(senderId).orElseThrow(() -> new RuntimeException("Sender not found"));
        User receiver = userRepository.findById(receiverId).orElseThrow(() -> new RuntimeException("Receiver not found"));

        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        message.setTime(LocalDateTime.now());

        return messageRepository.save(message);
    }

    public List<Message> getMessages(Long senderId, Long receiverId) {
        User sender = userRepository.findById(senderId).orElseThrow(() -> new RuntimeException("Sender not found"));
        User receiver = userRepository.findById(receiverId).orElseThrow(() -> new RuntimeException("Receiver not found"));

        List<Message> messagesFromSenderToReceiver = messageRepository.findBySenderAndReceiver(sender, receiver);
        List<Message> messagesFromReceiverToSender = messageRepository.findBySenderAndReceiver(receiver, sender);

        return Stream.concat(messagesFromSenderToReceiver.stream(), messagesFromReceiverToSender.stream())
                .sorted(Comparator.comparing(Message::getTime))
                .collect(Collectors.toList());
    }
}
