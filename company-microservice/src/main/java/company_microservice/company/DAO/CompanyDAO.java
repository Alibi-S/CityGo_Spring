package company_microservice.company.DAO;

import company_microservice.company.model.Company;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface CompanyDAO extends JpaRepository<Company, Long> {

    Optional<Company> findCompanyByCompanyName(String companyName);

    Optional<Company> findCompanyByBIK(String bik);

    Optional<Company> findCompanyByAddress(String address);
}
