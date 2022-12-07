package com.example.demorabbitmq.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigQueue {
    final String QUEUE_NAME = "convertdpf";
    final String EXCHANGE_NAME = "customexchange";
    final String ROUTING_KEY = "";


    //Create a new queue or use a queue has exist in system
    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    //Create a new exchange or use a exchange has exist in system
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME, true, false);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
