package com.example.KafkaProducerApplication.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createTopic()
    {
        System.out.println("Topic Creation Bean");
        return new NewTopic("config-topic-1", 5, (short) 1);
    }
}
