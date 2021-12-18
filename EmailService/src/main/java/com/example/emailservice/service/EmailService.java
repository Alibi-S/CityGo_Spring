package com.example.emailservice.service;

import com.example.emailservice.model.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    public void sendEmailMessage(EmailMessage emailMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        //message.setTo("26277@edu.iitu.kz");
        message.setTo(emailMessage.getTo());
        message.setSubject(emailMessage.getSubject());
        message.setText(emailMessage.getText());
        emailSender.send(message);
    }

}
