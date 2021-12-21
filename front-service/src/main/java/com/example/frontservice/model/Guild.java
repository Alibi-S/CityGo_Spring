package com.example.frontservice.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Guild {
    private Long id;
    private String name;
    private String description;
}
