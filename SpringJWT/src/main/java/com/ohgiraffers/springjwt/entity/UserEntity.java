package com.ohgiraffers.springjwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/* 설명. #3. DB에서 받아온 회원정보를 넣어줄 Entity */
@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    /* 설명. 사용자의 권한을 나타내줄 role */
    private String role;
}
