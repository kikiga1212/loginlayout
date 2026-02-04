package com.example.loginlayout.Config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * CustomSuccessHandler
 *
 * ▶ 역할
 * - Spring Security 로그인 성공 시 실행되는 커스텀 핸들러
 * - 로그인 성공 후 세션에 사용자 정보 저장
 * - 로그인 후 리다이렉트 처리
 *
 * ▶ 주요 기능
 * 1. 세션 가져오기
 * 2. 로그인한 사용자 이름(username) 조회
 * 3. 세션에 loginId로 저장
 * 4. 로그 출력
 * 5. 홈 페이지로 리다이렉트
 *
 * ▶ 특징
 * - AuthenticationSuccessHandler 인터페이스 구현
 * - @Component, @Slf4j 적용
 * - UserDetails.getUsername() 사용
 */
@Slf4j
@Component
public class CustomSuccessHandler  implements AuthenticationSuccessHandler {

    /**
     * 로그인 성공 시 처리
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param authentication 인증 정보 객체
     * @throws IOException
     * @throws ServletException
     */

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("로그인 성공후 섹션처리");
        HttpSession session = request.getSession();
        String username = authentication.getName();//로그인한 아이디를 저장해서

        session.setAttribute("loginId", username);//loginId섹션명으로 아이디를 저장

        response.sendRedirect("/");


    }
}
