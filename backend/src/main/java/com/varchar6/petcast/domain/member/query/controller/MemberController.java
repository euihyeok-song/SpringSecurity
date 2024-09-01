package com.varchar6.petcast.domain.member.query.controller;

import com.varchar6.petcast.domain.member.command.application.dto.request.MemberRequestDTO;
import com.varchar6.petcast.domain.member.command.application.vo.RequestRegistUserVO;
import com.varchar6.petcast.domain.member.command.application.vo.ResponseRegistUserVO;
import com.varchar6.petcast.domain.member.query.dto.MemberDTO;
import com.varchar6.petcast.domain.member.query.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController(value = "queryMemberController")
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;
    private ModelMapper modelMapper;

    @Autowired
    public MemberController(MemberService memberService, ModelMapper modelMapper) {
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("{memberId}")
    public ResponseEntity<MemberDTO> getMember(@PathVariable("memberId") Integer memberId) {
        log.debug("MemberDTO: {}", memberService.getMemberInformationById(memberId));
        return ResponseEntity.ok()
                .body(memberService.getMemberInformationById(memberId));
    }

}
