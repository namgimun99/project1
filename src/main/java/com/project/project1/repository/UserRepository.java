package com.project.project1.repository;

import com.project.project1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository<Entity 타입, Id 타입> 상속 <- Spring Data JPA에서 지원
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
