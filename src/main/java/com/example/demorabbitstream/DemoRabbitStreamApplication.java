package com.example.demorabbitstream;

import com.rabbitmq.stream.Address;
import com.rabbitmq.stream.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.EnvironmentBuilderCustomizer;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class DemoRabbitStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRabbitStreamApplication.class, args);
    }

    @Bean
    EnvironmentBuilderCustomizer environmentBuilderCustomizer(RabbitProperties rabbitProperties) {
        RabbitProperties.Stream rabbitStreamProperties = rabbitProperties.getStream();
        return builder -> builder
                .addressResolver(add -> new Address(rabbitStreamProperties.getHost(), rabbitStreamProperties.getPort()));
    }

    @RabbitListener(id = "consumer", queues = "stream.test")
    public void consumerStream0(Message msg) {
        log.info("consumer-0-0:{}", msg.getBody());
    }
}
