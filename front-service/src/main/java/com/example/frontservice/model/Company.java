package com.example.frontservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private int id;

    private String companyName;
    private String BIK;
    private String address;
}
