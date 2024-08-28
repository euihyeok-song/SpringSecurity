package com.ohgiraffers.springjwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/* 설명. #1. Controller 설정 */
@Controller
/* 설명. Web로 동작하는 것이 아닌 api로 문자형태로 나오기 때문에 선언 필요*/
@ResponseBody
public class AdminController {

    @GetMapping("/admin")
    public String adminP(){
        return "admin Controller";
    }
}
