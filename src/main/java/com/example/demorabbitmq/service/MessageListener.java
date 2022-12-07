package com.example.demorabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = "convertdpf")
    public void receiveMessage(String message){
        System.out.println("Kiem tra message: "+message);
    }
}
