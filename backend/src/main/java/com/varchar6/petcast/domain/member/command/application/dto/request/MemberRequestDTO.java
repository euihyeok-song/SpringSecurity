package com.varchar6.petcast.domain.member.command.application.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDTO {
    private String loginId;
    private String password;
    private String name;
    private String phone;
    private String nickname;
    private String image;
    private String introduction;

    /* 설명. 인증을 위해 필요한 고유 userId를 설정*/
//    private String userId;
}
