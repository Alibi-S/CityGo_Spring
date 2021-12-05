package com.example.loggingapi.messaging;
import com.example.loggingapi.model.Log;
import com.example.loggingapi.service.LogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMqListener {
    @Autowired
    public LogService logService;

    @RabbitListener(queues = "queue1")
    public void processQueue1(String message) {
        System.out.println("Received from queue 1: " + message);
        String[] splited = message.split("\\s+");
        Log log = new Log();
        log.setUserId(Long.parseLong(splited[0]));
        log.setService(splited[1]);
        log.setAction(splited[2]);
        log.setDescription(splited[3]);
        logService.CreateLog(log);
    }
}