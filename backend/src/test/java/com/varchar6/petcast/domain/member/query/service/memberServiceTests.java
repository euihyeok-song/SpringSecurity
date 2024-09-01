package com.varchar6.petcast.domain.member.query.service;

import com.varchar6.petcast.domain.member.command.application.service.MemberServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.varchar6.petcast.domain.member.command.application.dto.request.MemberRequestDTO;
import com.varchar6.petcast.domain.member.command.application.dto.response.MemberResponseDTO;

@SpringBootTest
class MemberServiceTests {
    @Autowired
    private com.varchar6.petcast.domain.member.query.service.MemberService queryMemberService;
    @Autowired
    private MemberServiceImpl commandMemberService;

    private MemberRequestDTO memberRequestDTO = new MemberRequestDTO();

    @Test
    public void 멤버아이디로_멤버_조회() {
        int input_number = 1;

        int memberId = queryMemberService.getMemberInformationById(input_number).getId();
        Assertions.assertTrue((input_number == memberId));
    }

    @Test
    @Transactional
    public void 멤버생성_및_조회() {
        memberRequestDTO.setLoginId("testLoginId");
        memberRequestDTO.setPassword("testPassword");
        memberRequestDTO.setName("testName");
        memberRequestDTO.setPhone("testPhone");
        memberRequestDTO.setNickname("testNickname");
        memberRequestDTO.setImage("testImage");
        memberRequestDTO.setIntroduction("testIntroduction");
        MemberResponseDTO memberResponseDTO = commandMemberService.registerMember(memberRequestDTO);

        Assertions.assertEquals("testLoginId", memberResponseDTO.getLoginId());
    }

}