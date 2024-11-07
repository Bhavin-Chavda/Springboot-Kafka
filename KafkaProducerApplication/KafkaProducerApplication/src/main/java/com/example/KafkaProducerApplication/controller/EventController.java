package com.example.KafkaProducerApplication.controller;

import com.example.KafkaProducerApplication.service.KafkaMessagingPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagingPublisher kafkaMessagingPublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message)
    {
        try{
            for(int i=0;i<10000;i++)
            {
                kafkaMessagingPublisher.sendMessageToTopic(message+" : "+i);
            }
            return ResponseEntity.ok("Message Published  Successfully ....");
        }
        catch (Exception e)
        {
            System.out.println("Exception at Controller : "+e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
