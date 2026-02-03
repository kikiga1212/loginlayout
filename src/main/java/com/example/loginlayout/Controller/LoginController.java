package com.example.loginlayout.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * LoginController
 *
 * ▶ 역할
 * - 로그인 페이지 요청을 처리하는 컨트롤러
 * - 사용자 인증 화면(View) 제공
 *
 * ▶ 주요 기능
 * - 로그인 페이지(login.html) 렌더링
 *
 * ▶ 처리 흐름
 * 1. 사용자 요청 수신 ("/login")
 * 2. 로그인 뷰 반환
 *
 * ▶ 특징
 * - @Controller 사용
 * - 단순 페이지 렌더링용 컨트롤러
 * - Spring Security 로그인 폼과 연동
 */
@Controller
public class LoginController {

    /**
     * 로그인 페이지 요청 처리
     * 1. "/login" URL 요청 시 호출
     * 2. login.html 뷰 반환
     *
     * @return 로그인 페이지
     */
    @GetMapping("/login")
    public String login() {
        return null;
    }
}
