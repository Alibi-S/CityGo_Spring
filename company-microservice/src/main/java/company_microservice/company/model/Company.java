package company_microservice.company.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String BIK;
    private String address;
}
