package com.example.loggingapi.DAO;

import com.example.loggingapi.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDAO extends JpaRepository<Log, Long> {

}
