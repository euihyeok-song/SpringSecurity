package test.springjwt.company.command.application.service;

import com.varchar6.petcast.domain.company.command.application.dto.request.CompanyDeleteRequestDTO;
import com.varchar6.petcast.domain.company.command.application.dto.request.CompanyRegistRequestDTO;
import com.varchar6.petcast.domain.company.command.application.dto.request.CompanyUpdateRequestDTO;
import com.varchar6.petcast.domain.company.command.application.dto.response.CompanyResponseDTO;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Slf4j
@Service(value="commandCompanyServiceImpl")
public class CompanyServiceImpl implements CompanyService{


    private static final String FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMAT);

    @Override
    @Transactional
    public CompanyResponseDTO updateCompany(CompanyUpdateRequestDTO companyUpdateRequestDTO) {

    }

    @Override
    @Transactional
    public CompanyResponseDTO registerCompany(CompanyRegistRequestDTO companyRegistRequestDTO) {

    }

    @Override
    @Transactional
    public CompanyResponseDTO deleteCompany(CompanyDeleteRequestDTO companyDeleteRequestDTO) {

    }
}
