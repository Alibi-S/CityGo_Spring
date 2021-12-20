package com.example.emailservice.messaging;

import com.example.emailservice.model.EmailMessage;
import com.example.emailservice.service.EmailService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMqListener {
    @Autowired
    //public LogService logService;
    public EmailService emailService;

    @RabbitListener(queues = "emailSendQ")
    public void processEmailSendQ(EmailMessage emailMessage) {
//        System.out.println("Received from queue 1: " + message);
//        String[] splited = message.split("\\W+");
//        Log log = new Log();
//        log.setUserId(Long.parseLong(splited[0]));
//        log.setService(splited[1]);
//        log.setAction(splited[2]);
//        //log.setDescription(splited[3]);
//
//        System.out.println("Splited0: " + splited[0]);
//        System.out.println("Splited1: " + splited[1]);
//        System.out.println("Splited2: " + splited[2]);
//        System.out.println("Splited3: " + splited[3]);
//
//        if (splited[3].equals("Created") || splited[3].equals("Send_message")) {
//            //message.split("\\W+")
//            String descr = splited[3] + message.substring(message.indexOf(": "));
//            log.setDescription(descr);
//        }
//
//        logService.CreateLog(log);
        System.out.println(emailMessage.toString());

    }
}

//log = adasdaa, game = asdas,