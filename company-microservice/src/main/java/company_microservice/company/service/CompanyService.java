package company_microservice.company.service;

import company_microservice.company.DAO.CompanyDAO;
import company_microservice.company.model.Company;
import company_microservice.company.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyDAO companyDAO;

    @Autowired
    private RestTemplate restTemplate;

    public void createLog(Long userId, String action, String description){
        Log log = new Log(userId, "CompanyService", action, description);
        HttpEntity<Log> request = new HttpEntity<>(log);
        restTemplate.postForObject("http://logging-api/logs", request, Log.class);
        System.out.println(log.toString());
    }


//    @HystrixCommand(
//            fallbackMethod = "getChallengeDtoByIdFallback"
//    )


    public List<Company> findAllCompany() {
        createLog(1L, "GET", "List of companies");
        return companyDAO.findAll();
    }

    public Company getCompanyById(Long id){
        createLog(1L, "GET", "Get company, id = " + id);
        return companyDAO.getById(id);
    }

    public Optional<Company> findCompanyByName(String companyName){
        createLog(1L, "GET", "Get company, name = " + companyName);
        return companyDAO.findCompanyByCompanyName(companyName);
    }

    public Optional<Company> findCompanyByBIK(String bik){
        createLog(1L, "GET", "Get company, bik = " + bik);
        return companyDAO.findCompanyByBIK(bik);
    }

    public Optional<Company> findCompanyByAddress(String address){
        createLog(1L, "GET", "Get company, address = " + address);
        return companyDAO.findCompanyByAddress(address);
    }

    public void createCompany(Company company){
        createLog(1L, "POST", "Created: " + company.toString() );
        companyDAO.save(company);
    }

    public void deleteCompany(Long id){
        createLog(1L, "DELETE", "Delete company, id = " + id);
        companyDAO.deleteById(id);
    }

    public Optional<Company> findById(Long id) {
        createLog(1L, "GET", "Get company, id = " + id);
        return companyDAO.findById(id);
    }
}
