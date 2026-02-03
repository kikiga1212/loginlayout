package com.example.loginlayout.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * CustomUserDetailsService
 *
 * ▶ 역할
 * - Spring Security의 인증(Authentication) 처리용 서비스
 * - 데이터베이스(MemberRepository)에서 사용자 정보를 조회하여
 *   Spring Security가 사용할 UserDetails 객체 생성
 *
 * ▶ 주요 기능
 * - username을 기준으로 사용자 조회
 * - 조회된 사용자 정보를 UserDetails로 변환
 * - 사용자 없을 시 UsernameNotFoundException 발생
 *
 * ▶ 특징
 * - UserDetailsService 인터페이스 구현
 * - Spring Security 로그인 과정에서 자동 호출
 * - 권한(Role) 정보를 UserDetails에 포함
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService  {

    /**
     * username 기반 사용자 조회 및 UserDetails 반환
     *
     * 처리 단계:
     * 1. memberRepository에서 username으로 MemberEntity 조회
     * 2. 존재하면 Spring Security의 User 객체로 변환
     *    - username, 암호화된 password, 권한(Role) 포함
     * 3. 존재하지 않으면 UsernameNotFoundException 예외 발생
     *
     * @param username 로그인 시 입력한 사용자 이름
     * @return UserDetails Spring Security 인증용 사용자 정보
     * @throws UsernameNotFoundException 사용자가 존재하지 않을 경우
     */

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return null;
    }

}
