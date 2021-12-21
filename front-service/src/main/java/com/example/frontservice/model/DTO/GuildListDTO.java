package com.example.frontservice.model.DTO;

import com.example.frontservice.model.Guild;
import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GuildListDTO {
    private ArrayList<Guild> guilds;
}
