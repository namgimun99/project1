package com.project.project1.repository;

import com.project.project1.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 스프링 context를 로딩하여 테스트
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {

        User user = User.builder()
                .name("남기문")
                .loginId("ngm011")
                .password("1234")
                .email("ngm011@naver.com")
                .createTime(LocalDateTime.now())
                .build();

        userRepository.save(user); // INSERT

    }

}