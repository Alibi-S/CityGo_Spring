package com.example.challengesapi.service;

import com.example.challengesapi.dao.ChallengeDAO;
import com.example.challengesapi.model.Challenge;
import com.example.challengesapi.model.Company;
import com.example.challengesapi.model.DTO.ChallengeCompanyDTO;
import com.example.challengesapi.model.DTO.ChallengeListDTO;
import com.example.challengesapi.model.Log;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    @Autowired
    private ChallengeDAO challengeDAO;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    AmqpTemplate amqpTemplate;


    public void createLog(Long userId, String action, String description){
//        Log log = new Log(userId, "ChallengeService", action, description);
//        HttpEntity<Log> request = new HttpEntity<>(log);
//        restTemplate.postForObject("http://logging-api/logs", request, Log.class);
//        System.out.println(log.toString());

        Log log = new Log(userId, "ChallengeService", action, description);
        //HttpEntity<Log> request = new HttpEntity<>(log);
        //restTemplate.postForObject("http://logging-api/logs", request, Log.class);
        System.out.println(log.toString());
        String logForAmqp = log.getUserId() + " " + log.getService() + " " + log.getAction() + " " + log.getDescription();
        amqpTemplate.convertAndSend("queue1", logForAmqp);

    }

    public void createChallenge(Challenge challenge) {
        //?????? ???????????????? ?????????????? ???? ???????????????? ???????? ????????????????, ?? ???? ?????????? ?????? ?????? ?????????????? ?????????? ????????????????
        //???????????? ???????????????????????????? ?????? ?????????????? ???? ???????????? ?????????????????? ????????????????????, ?????? ?????????? ???? ?????????????????? ????????????????
        //?? ???????????????????????? ???????????? ???????????????? ?????? ????????????????.

        Company cp = restTemplate.getForObject("http://company-crud-api/company/" + challenge.getSponsorId(), Company.class);
        //?????? ?????????????? ???????????? ????????????????

        if(cp != null) {
            challengeDAO.save(challenge);
            createLog(1L, "POST", "Created: " + challenge.toString());
        } else {
            createLog(1L, "POST", "Not created: " + challenge.toString());
            System.out.println("Company not found! Challenge not created!");
        }
    }

    public List<Challenge> getChallengeList() {
        createLog(1L, "GET", "List of challenge");
        return challengeDAO.findAll();
    }

    public void deleteChallenge(Challenge challenge) {
        createLog(1L, "DELETE", "Delete: " + challenge.toString());
        challengeDAO.delete(challenge);
    }

    public void updateChallenge(Challenge challenge) {
        createLog(1L, "UPDATE", "Update: " + challenge.toString());

        Challenge originalChallenge = challengeDAO.getById(challenge.getId());
        if (originalChallenge != null) {
            challengeDAO.save(challenge);
        }
    }

    @HystrixCommand(
            fallbackMethod = "getChallengeDtoByIdFallback",
            threadPoolKey = "getChallengeDtoById",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value="100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            }
    )
    public ChallengeCompanyDTO getChallengeDtoById(Long id) {
        Optional<Challenge> challenge = challengeDAO.findById(id);

        Company cp = restTemplate.getForObject("http://company-crud-api/company/" + Long.toString(challenge.get().getSponsorId()), Company.class);

        ChallengeCompanyDTO challengeCompanyDTO = new ChallengeCompanyDTO(challenge, cp);

        createLog(1L, "GET", "Get Challenge DTO: " + challengeCompanyDTO.toString());
        return challengeCompanyDTO;
    }

    public ChallengeCompanyDTO getChallengeDtoByIdFallback(Long id) {
        Optional<Challenge> challenge = challengeDAO.findById(id);
        Company cp = new Company(0, "Not found", "0000", "empty address");

        ChallengeCompanyDTO challengeCompanyDTO = new ChallengeCompanyDTO(challenge, cp);
        createLog(1L, "GET", "Get Challenge DTO: " + challengeCompanyDTO.toString());
        return challengeCompanyDTO;
    }

    public Optional<Challenge> getChallenge(Long id) {
        createLog(1L, "GET", "Get Challenge by id: " + id);
        return challengeDAO.findById(id);
    }

    public ChallengeListDTO getChallengeListDto() {
        ArrayList<Challenge> challenges = (ArrayList<Challenge>) challengeDAO.findAll();

        ChallengeListDTO challengeListDTO = new ChallengeListDTO(challenges);
        return  challengeListDTO;
    }
}
