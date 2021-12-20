package com.example.guildsapi2.dao;

import com.example.guildsapi2.model.Guild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuildDAO extends JpaRepository<Guild, Long> {

}
