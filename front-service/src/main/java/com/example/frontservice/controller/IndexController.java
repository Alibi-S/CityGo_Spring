package com.example.frontservice.controller;


import com.example.frontservice.model.Challenge;
import com.example.frontservice.model.DTO.ChallengeListDTO;
import com.example.frontservice.model.DTO.LogListDTO;
import com.example.frontservice.model.EmailMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;


//    @Autowired
//    AmqpTemplate amqpTemplate;
//    @Autowired
//    private MessageRepo messageRepo;

    @GetMapping("/")
    //   public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model/*Model model*/) {
    public String greeting(Map<String, Object> model/*Model model*/) {

        //model.addAttribute("name", name);
        //model.put("name", name);
        return "main";
    }

    @GetMapping("/login")
    public String autorization(Map<String, Object> model) {
        return "autorization";
    }

    @GetMapping("/registration")
    public String registration(Map<String, Object> model) {
        return "registration";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
//        LogListDTO logList = restTemplate.getForObject("http://logging-api/logs/dto", LogListDTO.class);
        LogListDTO logList = restTemplate.getForObject("http://zuul-service/logs/dto", LogListDTO.class);
        System.out.println(logList.getLogs().toString());
        model.addAttribute("logs", logList.getLogs());

//
//        EmailMessage emailMessage = new EmailMessage("alibisemeikhan@yandex.kz", "Subject", "Text");
//
//        HttpEntity<Challenge> request = new HttpEntity<>(emailMessage);
//        restTemplate.postForObject("http://zuul-service/challenges/register", request, Challenge.class);
//
//
//        System.out.println("\nTEST------------------------------" +
//                "\n__+_+_+_+_+_+_+_+_+_+\n" + emailMessage.toString());
//

        return "adminpage";
    }

    @GetMapping("/admin_challenges")
    public String challengeAdmin(Model model) {
        ChallengeListDTO challengeListDTO = restTemplate.getForObject("http://zuul-service/challenges/dto", ChallengeListDTO.class);
        model.addAttribute("challenges", challengeListDTO.getChallengeList());
        return "challenges_admin";
}

    @PostMapping("/admin_challenges")
    public String createChallenge(@ModelAttribute Challenge challenge, BindingResult bindingResult, Model model) {

        System.out.println(challenge.toString());
        HttpEntity<Challenge> request = new HttpEntity<>(challenge);
        restTemplate.postForObject("http://zuul-service/challenges/register", request, Challenge.class);

        return "redirect:adminpage";
    }


    @GetMapping("/admin_email")
    public String emailAdmin(Model model) {
        ChallengeListDTO challengeListDTO = restTemplate.getForObject("http://zuul-service/challenges/dto", ChallengeListDTO.class);
        model.addAttribute("challenges", challengeListDTO.getChallengeList());
        return "email_admin";
    }

    //@RequestMapping(value = "/admin_email", method = RequestMethod.POST)
    @PostMapping("/admin_email")
    public RedirectView sendEmailAdmin(@ModelAttribute EmailMessage emailMessage, BindingResult bindingResult, Model model) {

        //System.out.println(challenge.toString());
        HttpEntity<EmailMessage> request = new HttpEntity<>(emailMessage);
        restTemplate.postForObject("http://zuul-service/email/send", request, EmailMessage.class);
        //amqpTemplate.convertAndSend(emailMessage);

        return new RedirectView("/admin");//"redirect:/admin";

    }

}