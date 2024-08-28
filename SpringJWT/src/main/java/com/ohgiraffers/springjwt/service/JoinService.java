package com.ohgiraffers.springjwt.service;

import com.ohgiraffers.springjwt.dto.JoinDTO;
import com.ohgiraffers.springjwt.entity.UserEntity;
import com.ohgiraffers.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/* 설명. #8. Join을 통해 로그인을 처리할 Service 계층을 만들어 줌 */
@Service
public class JoinService {

    /* 설명. #8-2. UserRepository로 붙어 받은 메소드의 결과값을 의존성 주입을 통해서 받아옴 */
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(JoinDTO joinDTO){

        /* 설명. 1. joinDTO에서 username, password를 받아옴*/
        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();


        /* 설명. 2. username을 통해 사용자가 겹쳤는지를 확인하고 예외 처리 -> DB값이 있는 USerRepository로 가서 메소드 생성해줘야 함*/
        Boolean isExist = userRepository.existsByUsername(username);

        /* 설명. 동일한 username이 존재할 경우 로그인이 안되게 막음*/
        if (isExist){

            return;
        }

        /* 설명. 3. 중복되는 username이 없음으로 회원가입 진행 -> UserDTO로 받아온 정보를 UserEntity에 저장 */
        UserEntity data = new UserEntity();

        data.setUsername(username);
        /* 설명. password는 무조건 암호화를 진행하여서 넣어야 한다 -> config의 bCryptPasswordEncoder를 이용 */
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");         // spring은 권한 부여시 앞에 ROLE_을 붙여준다.

        /* 설명. 4. UserRepository에서 Entity값을 저장 */
        userRepository.save(data);
    }

}
