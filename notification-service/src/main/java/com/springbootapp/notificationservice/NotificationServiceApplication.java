package com.springbootapp.notificationservice;

import com.springbootapp.notificationservice.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void notification(OrderPlacedEvent orderPlacedEvent){
        //send out and email notification.
        log.info("Received Notification For Order : {}", orderPlacedEvent.getOrderNumber());
    }

}
