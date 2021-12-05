package com.example.frontservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Challenge {
    private Long id;
    private String riddle;
    private String answer;
    private Long sponsorId;
    private Date startDate;
    private Date endDate;
}
