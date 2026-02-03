package com.example.loginlayout.DTO;

import com.example.loginlayout.Constant.RoleType;
import lombok.*;

/**
 * MemberDTO
 *
 * ▶ 역할
 * - Controller ↔ Service 계층 간 데이터 전달 객체
 * - 회원 관련 사용자 입력 데이터 및 정보 전달용
 *
 * ▶ 주요 기능
 * - 회원 ID, 이름, 계정 정보 및 권한(Role) 데이터 저장
 *
 * ▶ 특징
 * - Entity와 분리하여 사용
 * - 비밀번호 등 민감 데이터 포함 가능
 * - DB와 직접적인 연관 없음
 */
@Getter @Setter
@ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class MemberDTO {
    private Long id;
    private String firstName;   //이름
    private String lastName;    //성
    private String username;    //아이디
    private String password;    //비밀번호
    private RoleType role;      //권한


}
