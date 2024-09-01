package com.varchar6.petcast.security;

import com.netflix.discovery.converters.Auto;
import com.varchar6.petcast.domain.member.command.application.service.MemberService;
import com.varchar6.petcast.domain.member.command.domain.aggregate.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    private MemberService memberService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurity(MemberService memberService,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberService = memberService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {

         /* 설명. csrf 비활성화 */
        http.csrf((csrf) -> csrf.disable());

        /* 설명. AuthenticationManager 등록을 위한 builder 생성 */
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        /* 설명. Manager를 사용할 service(우리) + 암호화 방식 설정 */
        authenticationManagerBuilder.userDetailsService(memberService)
                .passwordEncoder(bCryptPasswordEncoder);

        /* 설명. AuthenticationManager 등록 */
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        /* 설명. Request의 권한 지정 */
        http.authorizeHttpRequests((authz) ->
                authz.requestMatchers(new AntPathRequestMatcher("/api/v1/member/**")).permitAll()
                        .anyRequest().authenticated()
        )
                /* 설명. authenicationManager에 권한 범위 지정 후 등록 */
                .authenticationManager(authenticationManager)
                /* 설명. session을 STATELESS로 지정 (연결할 떄마다 권한 인증받고 사용)*/
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
