package com.example.loginlayout.Controller;

import com.example.loginlayout.DTO.MemberDTO;
import com.example.loginlayout.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * MemberController
 *
 * ▶ 역할
 * - 회원 가입 관련 요청을 처리하는 컨트롤러
 * - 사용자 등록 화면(View) 제공 및 회원 저장
 *
 * ▶ 주요 기능
 * - 회원 가입 페이지 렌더링
 * - 회원 등록 처리 후 로그인 페이지로 리다이렉트
 *
 * ▶ 처리 흐름
 * 1. "/register" GET 요청 시 회원 가입 페이지 반환
 * 2. "/register" POST 요청 시 회원 정보 저장
 * 3. 저장 후 "/login" 페이지로 리다이렉트
 *
 * ▶ 특징
 * - @Controller 사용
 * - Thymeleaf 및 Spring MVC 폼 연동
 * - Service 계층(MemberService)와 연결
 */
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 가입 페이지 요청 처리
     *
     * 처리 단계:
     * 1. "/register" GET 요청 시 호출
     * 2. 회원 가입 페이지(register.html) 뷰 반환
     *
     * @return 회원 가입 페이지
     */
    @GetMapping("/register")
    public String registerPage() {
        return null;
    }

    /**
     * 회원 등록 처리
     *
     * 처리 단계:
     * 1. "/register" POST 요청 시 호출
     * 2. 전달받은 MemberDTO를 Service에 전달하여 저장
     * 3. 저장 완료 후 로그인 페이지로 리다이렉트
     *
     * @param memberDTO 회원 정보 DTO
     * @return 로그인 페이지로 리다이렉트
     */
    @PostMapping("/register")
    public String registerPost(MemberDTO memberDTO) {

        return null;
    }
}
