package com.example.demorabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class RabbitMQController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("")
    public String sendDataRabbitMQ() {
        rabbitTemplate.convertAndSend("customexchange", "", "hello from controller Queue");
        return "";
    }
}
