package com.example.challengesapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "challenges")
@AllArgsConstructor
@NoArgsConstructor
public class Challenge {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String riddle;
    private String answer;
    private Long sponsorId;
    private Date startDate;
    private Date endDate;
}
