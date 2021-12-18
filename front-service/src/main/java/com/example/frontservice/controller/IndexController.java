package com.example.frontservice.controller;


import com.example.frontservice.model.Challenge;
import com.example.frontservice.model.DTO.ChallengeListDTO;
import com.example.frontservice.model.DTO.LogListDTO;
import com.example.frontservice.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

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
}