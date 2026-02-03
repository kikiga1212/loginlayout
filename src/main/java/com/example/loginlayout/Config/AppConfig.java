package com.example.loginlayout.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig
 *
 * ▶ 역할
 * - 애플리케이션 전반에서 사용하는 공용 설정 클래스
 * - 외부 라이브러리를 Spring Bean으로 등록
 *
 * ▶ 주요 기능
 * - ModelMapper를 Spring 컨테이너에 Bean으로 등록
 *
 * ▶ 사용 대상
 * - Service 계층
 * - DTO ↔ Entity 변환이 필요한 모든 컴포넌트
 *
 * ▶ 처리 흐름
 * 1. 애플리케이션 시작 시 Spring이 AppConfig를 로딩
 * 2. modelMapper() 메서드를 통해 ModelMapper 객체 생성
 * 3. Spring 컨테이너에 Bean으로 등록
 * 4. @Autowired / @RequiredArgsConstructor로 주입 가능
 *
 * ▶ 특징
 * - @Configuration을 사용하여 설정 클래스 명시
 * - @Bean으로 등록된 객체는 싱글톤으로 관리됨
 * - 중복 생성 방지 및 재사용성 향상
 */
@Configuration
public class AppConfig {
    /**
     * ModelMapper를 Spring이 관리하는 공용 객체로 만들어서
     * 프로젝트 전반에서 재사용할 수 있게 해주는 설정
     * @return
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
