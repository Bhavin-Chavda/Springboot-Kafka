package com.example.KafkaProducerApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagingPublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String msg)
    {
        CompletableFuture<SendResult<String, Object>> future = template.send("config-topic-1", msg);
        future.whenComplete((result,ex)->{

            if(ex==null)
            {
                System.out.println("Message Sent : " + msg +" , Offset Is : "+result.getRecordMetadata().offset());
                System.out.println("Partition is : "+result.getRecordMetadata().partition());
            }
            else {
                System.out.println("Exception Occured : "+ex.getMessage());
            }
        });
    }
}
