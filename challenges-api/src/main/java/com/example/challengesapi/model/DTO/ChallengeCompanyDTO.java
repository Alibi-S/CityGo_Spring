package com.example.challengesapi.model.DTO;

import com.example.challengesapi.model.Challenge;
import com.example.challengesapi.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Optional;


//@AllArgsConstructor
//@NoArgsConstructor
public class ChallengeCompanyDTO {
    private Long id;
    private String riddle;
    private String answer;
    private Long sponsorId;
    private Date startDate;
    private Date endDate;
    private Company company;


    public ChallengeCompanyDTO(Optional<Challenge> challenge, Company company) {
        this.id = challenge.get().getId();
        this.riddle = challenge.get().getRiddle();
        this.answer = challenge.get().getAnswer();
        this.sponsorId = challenge.get().getSponsorId();
        this.startDate = challenge.get().getStartDate();
        this.endDate = challenge.get().getEndDate();
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRiddle() {
        return riddle;
    }

    public void setRiddle(String riddle) {
        this.riddle = riddle;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(Long sponsorId) {
        this.sponsorId = sponsorId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
