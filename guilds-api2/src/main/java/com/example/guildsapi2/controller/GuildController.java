package com.example.guildsapi2.controller;

import com.example.guildsapi2.model.DTO.GuildListDTO;
import com.example.guildsapi2.model.Guild;
import com.example.guildsapi2.service.GuildService;
import com.example.guildsapi2.model.Guild;
import com.example.guildsapi2.service.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guilds")
public class GuildController {

    @Autowired
    private GuildService guildService;

    @PostMapping("/create")
    public void CreatePlace(@RequestBody Guild guild) {
        guildService.CreateGuild(guild);
    }

    @GetMapping("")
    public List<Guild> GetPlaces() {
        return guildService.GetGuilds();
    }

    @GetMapping("/dto")
    public GuildListDTO GetPlacesDto() {
        return guildService.GetGuildsDto();
    }


}