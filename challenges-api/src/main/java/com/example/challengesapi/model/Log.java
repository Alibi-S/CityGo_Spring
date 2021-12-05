package com.example.challengesapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
public class Log {
    private long userId;
    private String service;
    private String action;
    private String description;
}