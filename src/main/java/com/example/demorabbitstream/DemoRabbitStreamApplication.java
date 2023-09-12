package com.example.demorabbitstream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DemoRabbitStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRabbitStreamApplication.class, args);
    }

    @RabbitListener(id = "consumer", queues = "stream.test")
    public void consumerStream0(Message msg) {
        log.info("consumer-0-0:{}", msg.getBody());
    }
}
