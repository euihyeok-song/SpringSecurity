package test.springjwt.company.command.domain.repository;


import com.varchar6.petcast.domain.company.command.domain.aggregate.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
