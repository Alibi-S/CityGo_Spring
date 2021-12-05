package com.example.loggingapi.model.DTO;

import com.example.loggingapi.model.Log;
import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogListDTO {
    private ArrayList<Log> logs;
}
