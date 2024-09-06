package com.varchar6.petcast.domain.member.command.application.service;

import com.varchar6.petcast.domain.member.command.application.dto.request.MemberRequestDTO;
import com.varchar6.petcast.domain.member.command.application.dto.response.MemberResponseDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTests {

    MemberRequestDTO memberRequestDTO = new MemberRequestDTO();

    @Autowired
    private MemberServiceImpl memberService;

    @Test
    @Transactional
    public void 멤버_생성_확인() {
        memberRequestDTO.setLoginId("testId4");
        memberRequestDTO.setPassword("testPw");
        memberRequestDTO.setName("testName");
        memberRequestDTO.setPhone("testPhone");
        memberRequestDTO.setNickname("testNickname");
        memberRequestDTO.setImage("testImage");
        memberRequestDTO.setIntroduction("testIntroduction");
        MemberResponseDTO memberResponseDTO = memberService.registerMember(memberRequestDTO);
        assertEquals("testId4", memberResponseDTO.getLoginId());

    }



}