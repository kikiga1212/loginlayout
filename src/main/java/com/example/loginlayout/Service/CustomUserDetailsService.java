package com.example.loginlayout.Service;

import com.example.loginlayout.Entity.MemberEntity;
import com.example.loginlayout.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    //로그인과 관련된 테이블의 repository 지정
    private final MemberRepository memberRepository;


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

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        log.info("로그인 정보 읽기");
        Optional<MemberEntity> memberEntity = memberRepository.findByUsername(username);

        if(memberEntity.isPresent()){//아이디가 존재하면
            log.info("회원의 정보를 전달");
            return User.withUsername(memberEntity.get().getUsername())
                .password(memberEntity.get().getPassword())
                .roles(memberEntity.get().getRole().name())
                .build();
        }else {
            throw new UsernameNotFoundException("존재하지 않는 id입니다.");
        }

    }

}
