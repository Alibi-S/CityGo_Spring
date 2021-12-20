package com.example.frontservice.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Place {
    private Long id;
    private String name;
    private String coordinate;
    private String address;
    private String description;
    private String email;
    private boolean accept;
}
