package com.ohgiraffers.springjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/* 설명. #2. Security 기본 설정*/
@Configuration
/* 설명. Security 설정을 위한 Annotation */
@EnableWebSecurity
public class SecurityConfig {

    /* 설명. B. 비밀번호를 hash 알고리즘을 통해서 암호화한 것을 통해서 검증 */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /* 설명. A. 메소드를 빈등록을 해줌 (filterChian) */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        /* 설명. 1. csrf disable 설정 필요 -> JWT는 session을 stateless로 관리( 보호 필요X )  */
        http
                .csrf((auth) -> auth.disable());


        /* 설명. 2. JWT방식 사용 -> From 로그인 방식, Http 로그인 방식을 disable 설정 */
        http
                .formLogin((auth) -> auth.disable());
        http
                .httpBasic((auth) -> auth.disable());


        /* 설명. 3. Controller에서 사용할 기능(로그인..) 에 대한 인가 작업 진행 */
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/login","/","join").permitAll()   // 로그인이나 main경로는 모든 권한 허용
                        .requestMatchers("/admin").hasRole("ADMIN")             // admin이라는 권한을 가진 자만 접근 가능
                        .anyRequest().authenticated());                           // 다른 요청은 로그인 한 사용자만 접근 가능


        /* 설명. 4. JWT방식은 session을 statelesss 방식으로 처리 */
        http
                .sessionManagement((session) -> session
                        . sessionCreationPolicy(SessionCreationPolicy.STATELESS));



        /* 설명. 반환은 빌더형 -> 현재는 람다식으로 변환되는 버전이 나오기도 함*/
        return http.build();
    }
}
