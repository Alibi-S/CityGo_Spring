package com.example.challengesapi.dao;

import com.example.challengesapi.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeDAO extends JpaRepository<Challenge, Long> {

}
