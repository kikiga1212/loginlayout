package com.example.loginlayout.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig
 *
 * ▶ 역할
 * - Spring Security 설정 클래스
 * - 인증(Authentication) 및 인가(Authorization) 정책 정의
 *
 * ▶ 주요 기능
 * - 사용자 로그인/로그아웃 처리
 * - URL별 접근 권한 설정
 * - 패스워드 인코딩 방식 정의 (BCrypt)
 * - 정적 리소스 및 회원가입/로그인 페이지 접근 허용
 *
 * ▶ 처리 흐름
 * 1. 모든 요청에 대해 인증/인가 정책 적용
 * 2. formLogin 설정을 통해 로그인 페이지 및 성공 시 리다이렉트 지정
 * 3. logout 설정으로 세션 무효화 및 쿠키 삭제 처리
 *
 * ▶ 특징
 * - @Configuration, @EnableWebSecurity 적용
 * - Java Config 방식으로 SecurityFilterChain 사용
 * - CustomSuccessHandler와 연동
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomSuccessHandler customSuccessHandler;

    /**
     * 패스워드 인코더 Bean
     *
     * ▶ 역할
     * - 사용자 패스워드를 안전하게 암호화
     *
     * ▶ 특징
     * - BCryptPasswordEncoder 사용
     *
     * @return PasswordEncoder 객체
     */
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    /**
     * Spring Security 필터 체인 설정
     *
     * ▶ 역할
     * - URL별 접근 권한 설정
     * - 로그인/로그아웃 처리 정의
     *
     * ▶ 처리 흐름
     * 1. CSRF 비활성화
     * 2. 정적 리소스 접근 허용
     * 3. 회원가입/로그인 페이지 접근 허용
     * 4. 그 외 요청은 인증 필요
     * 5. 로그인 페이지 및 성공 처리 설정
     * 6. 로그아웃 URL, 세션 무효화, 쿠키 삭제 설정
     *
     * @param http HttpSecurity 객체
     * @return SecurityFilterChain 객체
     * @throws Exception 예외 발생 가능
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())//csrf(변조방지)
                .authorizeHttpRequests(auth->auth //요청권한지정
                        //자원폴더 및 파일을 접근허용
                        .requestMatchers("/css/**", "/js/**", "/img/**","/scss/**", "/vendor/**").permitAll()
                        //요청 접근 허용
                        .requestMatchers("/", "/login", "/register").permitAll()
                        //접근허용을 제외한 모든 요청을 권한(나머지는 로그인사용자만 접근가능)
                        .anyRequest().authenticated()
                        //.requestMatchers().hasRole("USER") 특정권한만 접근가능
                        //.requestMatchers().hasAnyRole("ADMIN", "MANAGER") 특정권한들만 접근가능
                )
                .formLogin(form->form //로그인설정
                        .loginPage("/login")//사용할 로그인페이지 요청
                        .defaultSuccessUrl("/", true)//로그인성공시 이동할 요청
                        .successHandler(customSuccessHandler)
                        .permitAll()//로그인에 접근권한
                )
                .logout(logout->logout//로그아웃 설정
                        .logoutUrl("/logout") //로그아웃 요청
                        .logoutSuccessUrl("/login")//로그아웃 성고후 이동할 요청
                        .invalidateHttpSession(true)//해당섹션 정보를 삭제
                        .deleteCookies("JESSIONID")//클라이언트에 쿠기를 삭제
                );

        return http.build();
    }
}
