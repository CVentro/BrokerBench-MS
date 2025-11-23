package com.brokerbench.first_service.controller;

import com.brokerbench.first_service.dto.Message;
import com.brokerbench.first_service.factory.BrokerFactory;
import com.brokerbench.first_service.service.MessageService;
import com.brokerbench.first_service.service.RabbitMQProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;

    MessageController(MessageService messageService) {
       this.messageService = messageService;
    }

    @GetMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(){
        return new ResponseEntity<>("SUCCESS" , HttpStatus.OK);
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody Message message) {
        messageService.sendMessageService(message);

        return "Message sent successfully";
    }
}
