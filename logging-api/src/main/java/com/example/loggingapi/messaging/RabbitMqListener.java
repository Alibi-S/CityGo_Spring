package com.example.loggingapi.messaging;

import com.example.loggingapi.model.Log;
import com.example.loggingapi.service.LogService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
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
        String[] splited = message.split("\\W+");
        Log log = new Log();
        log.setUserId(Long.parseLong(splited[0]));
        log.setService(splited[1]);
        log.setAction(splited[2]);
        //log.setDescription(splited[3]);

        System.out.println("Splited0: " + splited[0]);
        System.out.println("Splited1: " + splited[1]);
        System.out.println("Splited2: " + splited[2]);
        System.out.println("Splited3: " + splited[3]);

        if (splited[3].equals("Created") || splited[3].equals("Send_message")) {
            //message.split("\\W+")
            String descr = splited[3] + message.substring(message.indexOf(": "));
            log.setDescription(descr);
        }

        logService.CreateLog(log);
    }
}

//log = adasdaa, game = asdas,