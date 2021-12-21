package com.example.guildsapi2.service;

import com.example.guildsapi2.dao.GuildDAO;
import com.example.guildsapi2.model.DTO.GuildListDTO;
import com.example.guildsapi2.model.Guild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuildService {

    @Autowired
    private GuildDAO guildDAO;

    public void CreateGuild(Guild guild) {
        guildDAO.save(guild);
    }

    public List<Guild> GetGuilds() {
        return guildDAO.findAll();
    }

    public GuildListDTO GetGuildsDto() {
        ArrayList<Guild> guilds = (ArrayList<Guild>) guildDAO.findAll();
        GuildListDTO guildListDTO = new GuildListDTO(guilds);

        return guildListDTO;
    }
}
