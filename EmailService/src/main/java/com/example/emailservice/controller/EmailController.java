package com.example.emailservice.controller;

import com.example.emailservice.model.EmailMessage;
import com.example.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/send")
    public void createLog(@RequestBody EmailMessage message) {
        System.out.println(message.toString());
        emailService.sendEmailMessage(message);
    }

}
