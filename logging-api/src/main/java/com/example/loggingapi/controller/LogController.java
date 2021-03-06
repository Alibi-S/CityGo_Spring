package com.example.loggingapi.controller;

import com.example.loggingapi.model.DTO.LogListDTO;
import com.example.loggingapi.model.Log;
import com.example.loggingapi.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("")
    public void createLog(@RequestBody Log log) {
        System.out.println(log);
        logService.CreateLog(log);
    }

    @GetMapping("")
    public List<Log> GetLogs() {
        return logService.GetListLogs();
    }

    @GetMapping("/dto")
    public LogListDTO GetLogsDto() {
        ArrayList<Log> logs = (ArrayList<Log>) logService.GetListLogs();
        LogListDTO logListDTO = new LogListDTO(logs);
        return logListDTO;
    }

}
