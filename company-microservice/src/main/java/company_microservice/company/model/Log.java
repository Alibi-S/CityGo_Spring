package company_microservice.company.model;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Log {
    private long userId;
    private String service;
    private String action;
    private String description;
}