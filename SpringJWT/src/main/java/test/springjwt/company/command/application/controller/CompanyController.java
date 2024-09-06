package test.springjwt.company.command.application.controller;

import com.varchar6.petcast.common.response.ResponseMessage;
import com.varchar6.petcast.domain.company.command.application.dto.request.CompanyDeleteRequestDTO;
import com.varchar6.petcast.domain.company.command.application.dto.request.CompanyRegistRequestDTO;
import com.varchar6.petcast.domain.company.command.application.dto.request.CompanyUpdateRequestDTO;
import com.varchar6.petcast.domain.company.command.application.dto.response.CompanyResponseDTO;
import com.varchar6.petcast.domain.company.command.application.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "commandCompanyController")
@RequestMapping("/api/v1/company")
@Slf4j
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<ResponseMessage> signUp(@RequestBody CompanyRegistRequestDTO companyRegistRequestDTO){

        CompanyResponseDTO companyResponseDTO = companyService.registerCompany(companyRegistRequestDTO);

        return ResponseEntity.ok(new ResponseMessage(201, "입점 정보 등록 성공"
                , companyResponseDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseMessage> updateCompany(@RequestBody CompanyUpdateRequestDTO companyUpdateRequestDTO){

        CompanyResponseDTO companyResponseDTO = companyService.updateCompany(companyUpdateRequestDTO);

        return ResponseEntity.ok(new ResponseMessage(201, "입점 정보 수정 성공"
                , companyResponseDTO));
    }

    @PutMapping("/delete")
    public ResponseEntity<ResponseMessage> deleteCompany(@RequestBody CompanyDeleteRequestDTO companyDeleteRequestDTO){

        CompanyResponseDTO companyResponseDTO = companyService.deleteCompany(companyDeleteRequestDTO);

        return ResponseEntity.ok(new ResponseMessage(201, "입점 정보 삭제 성공"
                , companyResponseDTO));
    }
 }
