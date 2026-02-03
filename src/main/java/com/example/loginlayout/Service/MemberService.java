package com.example.loginlayout.Service;

import com.example.loginlayout.DTO.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MemberService
 *
 * ▶ 역할
 * - 회원 관련 비즈니스 로직 정의
 * - Controller와 Repository 사이의 중간 계층
 *
 * ▶ 주요 기능
 * - 회원 등록
 * - 회원 조회 (단건, 전체, username 기준)
 * - 회원 정보 수정
 * - 회원 삭제
 * - 비밀번호 암호화 처리
 * - 회원 권한(Role) 자동 부여
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    /**
     * 신규 회원 등록
     * 1. username 중복 체크
     * 2. DTO를 Entity로 변환
     * 3. 비밀번호 암호화 처리
     * 4. 회원 권한(Role) 자동 부여
     * 5. 데이터베이스 저장 후 DTO 반환
     *
     * @param memberDTO 회원 등록 정보
     * @return 저장된 회원 정보 DTO
     */
    public MemberDTO save(MemberDTO memberDTO) {
        return null;
    }

    /**
     * ID로 회원 단건 조회
     * @param id 회원 고유번호
     * @return 회원 정보 DTO 또는 null
     */
    public MemberDTO findById(Long id) {
        return null;
    }

    /**
     * 전체 회원 조회
     * @return 회원 목록 DTO
     */
    public List<MemberDTO> findAll() {
        return null;
    }

    /**
     * username으로 회원 조회
     * @param username 로그인용 사용자 이름
     * @return 회원 정보 DTO 또는 null
     */
    public MemberDTO findByUsername(String username) {
        return null;
    }


    /**
     * 회원 정보 수정
     * 1. 데이터베이스에 존재하는 회원 조회
     * 2. 필요한 필드만 업데이트
     * 3. 비밀번호는 암호화 처리
     * 4. 수정된 Entity를 DB에 저장 후 DTO 반환
     *
     * @param id 회원 고유번호
     * @param memberDTO 수정할 회원 정보
     * @return 수정된 회원 DTO 또는 null
     */
    public MemberDTO update(Long id, MemberDTO memberDTO) {

        return null;
    }

    /**
     * 회원 삭제
     * 1. 회원 존재 여부 확인
     * 2. 존재하면 삭제
     *
     * @param id 회원 고유번호
     * @return 삭제 성공 여부
     */
    public boolean delete(Long id) {

        return false;
    }
}
