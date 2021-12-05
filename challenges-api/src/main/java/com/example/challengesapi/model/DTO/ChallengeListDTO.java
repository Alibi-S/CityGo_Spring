package com.example.challengesapi.model.DTO;

import com.example.challengesapi.model.Challenge;

import java.util.ArrayList;

public class ChallengeListDTO {
    ArrayList<Challenge> challengeList;

    public ChallengeListDTO(ArrayList<Challenge> challengeList) {
        this.challengeList = challengeList;
    }

    public ArrayList<Challenge> getChallengeList() {
        return challengeList;
    }

    public void setChallengeList(ArrayList<Challenge> challengeList) {
        this.challengeList = challengeList;
    }

    @Override
    public String toString() {
        return "ChallengeListDTO{" +
                "challengeList=" + challengeList +
                '}';
    }
}
