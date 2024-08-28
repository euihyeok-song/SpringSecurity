package com.ohgiraffers.springjwt.dto;

import lombok.Getter;
import lombok.Setter;

/* 설명. #6. POST:/join을 통해서 사용자에게 받아온 username, password를 저장하는 공간 */
@Getter
@Setter
public class JoinDTO {

    private String username;
    private String password;
}
