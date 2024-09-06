package test.springjwt.company.command.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponseDTO {

    private int id;
    private String name;
    private String address;
    private Integer employeeNumber;
    private Integer career;
    private String license;
    private String introduction;
    private String contactableTime;
    private String createdAt;
    private String updatedAt;
    private Boolean active;
    private Boolean approved;
    private Integer memberId;
}
