package com.project.project1.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "T_USER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue //AutoIncrement
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String email;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;

    @PrePersist
    protected void onCreate() {
        this.createTime = LocalDateTime.now();
        this.modifyTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifyTime = LocalDateTime.now();
    }
}
