package com.example.frontservice.model.DTO;

import com.example.frontservice.model.Challenge;
import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChallengeListDTO {
    ArrayList<Challenge> challengeList;

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
