package com.example.loginlayout.Repository;

import org.springframework.stereotype.Repository;

/**
 * MemberRepository
 *
 * ▶ 역할
 * - MemberEntity에 대한 데이터 접근 계층
 * - 회원 정보 데이터베이스 CRUD 작업 담당
 *
 * ▶ 주요 기능
 * - 기본 CRUD 제공 (JpaRepository 상속)
 * - 사용자 이름(username)으로 회원 조회 기능 제공
 * - 페이징 및 정렬 기능 지원
 *
 * ▶ 특징
 * - SQL 작성 없이 JPA 메서드 사용
 * - Service 계층에서 호출되어 비즈니스 로직과 분리
 * - Optional을 반환하여 null 처리 안전
 */
@Repository
public interface MemberRepository  {

}
