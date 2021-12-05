package com.example.authorizationapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users")
public class User {
    private @Id @GeneratedValue long id;
    private String username;
    private String password;
    private String email;
}
