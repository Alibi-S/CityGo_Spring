package com.example.emailservice.service;

import com.example.emailservice.model.EmailMessage;
import com.example.emailservice.model.Log;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    AmqpTemplate amqpTemplate;



    public void createLog(Long userId, String action, String description){
        Log log = new Log(userId, "EmailService", action, description);
        String logForAmqp = log.getUserId() + " " + log.getService() + " " + log.getAction() + " " + log.getDescription();
        amqpTemplate.convertAndSend("queue1", logForAmqp);

        System.out.println(log.toString());
    }

    public void sendEmailMessage(EmailMessage emailMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        //message.setTo("26277@edu.iitu.kz");
        message.setTo(emailMessage.getTo());
        message.setSubject(emailMessage.getSubject());
        message.setText(emailMessage.getText());
        emailSender.send(message);

        createLog(1L, "POST", "Send_message: " + message.toString());
        System.out.println("\nMessage: " + message.toString());
    }

}
