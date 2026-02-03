package com.example.loginlayout.Constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * RoleType
 *
 * ▶ 역할
 * - 애플리케이션 내 사용자 권한(role) 구분을 위한 Enum
 *
 * ▶ 주요 기능
 * - 사용자 권한 정의
 *   - USER: 일반 사용자
 *   - MANAGER: 관리자(일부 관리 기능 가능)
 *   - ADMIN: 최고 관리자(모든 권한)
 *
 * ▶ 특징
 * - Enum 타입으로 정의되어 고정된 권한 값 사용
 * - Lombok @Getter, @AllArgsConstructor 적용
 * - MemberEntity와 연동하여 권한 관리
 */
@Getter
@AllArgsConstructor
public enum RoleType {
    USER, MANAGE, ADMIN

}
