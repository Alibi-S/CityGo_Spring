package com.example.loggingapi.service;

import com.example.loggingapi.DAO.LogDAO;
import com.example.loggingapi.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogDAO logDAO;

    public void CreateLog(Log log) {
        logDAO.save(log);
    }

    public List<Log> GetListLogs() {
        return logDAO.findAll();
    }
}