package com.project.project1.repository;

import com.project.project1.domain.User;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootTest // 스프링 context를 로딩하여 테스트
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void crud() {

        User user = User.builder()
                .username("ngm011")
                .password("1234")
                .email("ngm011@naver.com")
                .createTime(LocalDateTime.now())
                .build();

        user.encodePassword(passwordEncoder);

        userRepository.save(user); // INSERT

        System.out.println(userRepository.findAll());

        System.out.println(userRepository.findById(Long.valueOf(1)));

    }

}