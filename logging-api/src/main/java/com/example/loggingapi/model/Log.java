package com.example.loggingapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "logs")
public class Log {
    private @Id @GeneratedValue long id;
    private long userId;
    private String service;
    private String action;
    private String description;
}
