package test.springjwt.controller;

import test.springjwt.dto.JoinDTO;
import test.springjwt.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/* 설명. #7. JoinController */
@Controller
@ResponseBody       // api로 전달받아야 함으로 선언 필요
public class JoinController {

    /* 설명. #9. service 계층에서 받아온 메소들르 생성자 주입 */
    private final JoinService joinService;

    @Autowired
    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }


    /* 설명. 사용자에게 입력을 받는 값이기 떄문에 PostMapping */
    @PostMapping("/join")
    public String joinProcess(JoinDTO joinDTO){             // 입력을 받아서 저장한 DTO를 인자값으로 받음

        /* 설명. #9-2 controller와 service 연결 */
        joinService.joinProcess(joinDTO);

        return "ok";
    }


}
