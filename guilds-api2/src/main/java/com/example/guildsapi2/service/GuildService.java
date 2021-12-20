package com.example.guildsapi2.service;

import com.example.guildsapi2.dao.GuildDAO;
import com.example.guildsapi2.model.Guild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
