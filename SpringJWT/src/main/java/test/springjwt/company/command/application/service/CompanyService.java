package test.springjwt.company.command.application.service;

import com.varchar6.petcast.domain.company.command.application.dto.request.CompanyDeleteRequestDTO;
import com.varchar6.petcast.domain.company.command.application.dto.request.CompanyRegistRequestDTO;
import com.varchar6.petcast.domain.company.command.application.dto.request.CompanyUpdateRequestDTO;
import com.varchar6.petcast.domain.company.command.application.dto.response.CompanyResponseDTO;

public interface CompanyService {

    CompanyResponseDTO updateCompany(CompanyUpdateRequestDTO companyUpdateRequestDTO);

    CompanyResponseDTO registerCompany(CompanyRegistRequestDTO companyRegistRequestDTO);

    CompanyResponseDTO deleteCompany(CompanyDeleteRequestDTO companyDeleteRequestDTO);
}
