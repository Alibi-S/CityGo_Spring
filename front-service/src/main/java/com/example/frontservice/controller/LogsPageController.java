package com.example.frontservice.controller;

import com.example.frontservice.model.Answer;
import com.example.frontservice.model.Log;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class LogsPageController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/logs")
    public String getLogs(Model model) {
        ResponseEntity<List<Log>> rateResponse =
                restTemplate.exchange("http://logging-api/logs",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Log>>() {
                        });
        List<Log> logs = rateResponse.getBody();
////        HttpEntity<> requestEntity = ne HttpEntity<>(null, null);
//        ResponseEntity<String> resp = restTemplate.exchange("http://logging-api/logs", HttpMethod.GET, null, String.class);
//        ObjectMapper mapper = new ObjectMapper();
//        List<Log> logs = mapper.convertValue(resp.getBody(), new TypeReference<List<Log>>() {});
        model.addAttribute("logs", logs);
        return "logs";
    }
}

