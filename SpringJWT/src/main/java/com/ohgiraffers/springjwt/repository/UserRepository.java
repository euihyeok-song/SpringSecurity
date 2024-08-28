package com.ohgiraffers.springjwt.repository;

import com.ohgiraffers.springjwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/* 설명. #4. Repositoty 생성 -> 다음단계는 applicaiton.yml로 이동 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    /* 설명. #8-2. User가 겹치는 지를 확인하는 메소드 추가 */
    boolean existsByUsername(String username);
}
