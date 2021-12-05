package com.example.challengesapi.controller;

import com.example.challengesapi.model.Challenge;
import com.example.challengesapi.model.DTO.ChallengeCompanyDTO;
import com.example.challengesapi.model.Log;
import com.example.challengesapi.service.ChallengeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    @Autowired
    private ChallengeService service;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/register")
    public void createChallenge(@RequestBody Challenge challenge) { //
        //Challenge challenge = new Challenge(new Long(1), "Riddle for eureka???", "Answer!!!!", new Long(1), java.util.Calendar.getInstance().getTime(), java.util.Calendar.getInstance().getTime());
        service.createChallenge(challenge);
    }

    @PutMapping("/update")
    public void updateChallenge(@RequestBody Challenge challenge) {
        service.updateChallenge(challenge);
    }

    @GetMapping("")
    public List<Challenge> getAllChallenges() {
        return service.getChallengeList();
    }

    @GetMapping("/{id}")
    public ChallengeCompanyDTO getChallengeDtoById(@PathVariable Long id){
        return service.getChallengeDtoById(id);
    }

    @DeleteMapping("/delete")
    public void deleteChallenge(@RequestBody Challenge challenge) {
        service.deleteChallenge(challenge);
    }
}
