package com.example.loginlayout.Controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;

/**
 * IndexController
 *
 * ▶ 역할
 * - 애플리케이션의 메인 페이지 요청 처리
 * - 세션 정보를 View에 전달
 *
 * ▶ 주요 기능
 * - 메인 페이지(index) 렌더링
 * - 로그인 세션 정보(username) 모델에 전달
 *
 * ▶ 처리 흐름
 * 1. 사용자 요청 수신 ("/")
 * 2. 세션에서 로그인 아이디(loginId) 조회
 * 3. 모델에 로그인 아이디 전달
 * 4. index.html 렌더링
 *
 * ▶ 특징
 * - @Controller 사용
 * - 단순 페이지 렌더링용 컨트롤러
 * - 세션 기반 사용자 정보 처리
 */
@Controller
@Slf4j
public class IndexController {

    /**
     * 메인 페이지(index) 요청 처리
     * 1. HttpSession에서 로그인 아이디 가져오기
     * 2. Model에 username 속성으로 전달
     * 3. index.html 뷰 반환
     *
     * @param session 현재 HTTP 세션
     * @param model   View에 전달할 모델 객체
     * @return index 페이지
     */
    @GetMapping
    public String index(HttpSession session, Model model){
        log.info("세션에 저장된 사용자아이디를 저장");
        String loginId = (String)session.getAttribute("loginId");
        model.addAttribute("username",loginId);

        log.info("index페이지로 이동");
        return "index";
    }
}
