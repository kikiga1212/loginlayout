package com.example.loginlayout.Entity;

import com.example.loginlayout.Constant.RoleType;
import jakarta.persistence.*;
import lombok.*;

/**
 * MemberEntity
 *
 * ▶ 역할
 * - 회원 정보를 데이터베이스에 저장하기 위한 엔티티 클래스
 * - JPA를 통해 'membertable' 테이블과 매핑됨
 *
 * ▶ 주요 기능
 * - 회원 ID, 이름, 계정 정보 및 권한(Role) 관리
 *
 * ▶ 특징
 * - @Entity로 선언되어 JPA 관리 대상
 * - DB 테이블 컬럼 구조를 그대로 반영
 * - 비즈니스 로직을 포함하지 않음
 * - 비밀번호 등 민감 데이터 관리 가능
 */
@Entity
@Table(name="memberTable")
@Getter @Setter
@ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String firstName;   //이름
    @Column(length = 50, nullable = false)
    private String lastName;    //성
    @Column(length = 50, nullable = false, unique = true)
    private String username;    //아이디
    @Column(length = 100, nullable = false)
    private String password;    //비밀번호
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private RoleType role;      //권한

}
