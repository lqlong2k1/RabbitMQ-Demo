package com.example.demorabbitmq.rabbitmq;



import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerRabbitMQ {
    final String QUEUE_NAME = "convertdpf"; // tạm thời để thế này. Nên ở file .yml

    @Bean
    ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
//        container.setMessageListener(messageListenerAdapter);

        return container;
    }

    @Bean
    MessageListenerAdapter messageListenerAdapter(MessageListener messageListener) {
        return new MessageListenerAdapter(messageListener, "receiveMessage");
    }
}
