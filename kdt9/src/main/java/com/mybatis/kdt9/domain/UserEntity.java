package com.mybatis.kdt9.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity // 기본 생성자에 필요함
@Table(name="user")
@Getter
@Builder // 모든 필드를 가진 생성자를 생성한다
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment로 설정해라
    private int id;
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String nickname;

    // Enum 타입을 만들 수 있다.
//    @Column
//    @Enumerated(EnumType.STRING)
//    private UserType type;
//
//    public enum UserType {
//        STUDENT, TEACHER
//    }
}
