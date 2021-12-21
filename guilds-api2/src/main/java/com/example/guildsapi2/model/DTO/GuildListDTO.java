package com.example.guildsapi2.model.DTO;

import com.example.guildsapi2.model.Guild;
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
