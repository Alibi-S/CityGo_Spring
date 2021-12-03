package com.example.frontservice.model.DTO;

import com.example.frontservice.model.Log;
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
