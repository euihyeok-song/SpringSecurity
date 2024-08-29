package test.springjwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/* 설명. #1. Controller 설정 */
@Controller
@ResponseBody
public class MainController {

    @GetMapping("/")
    public String mainP(){
        return "Main Controller";
    }
}
