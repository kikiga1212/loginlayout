package com.example.loginlayout.Service;

import com.example.loginlayout.Constant.RoleType;
import com.example.loginlayout.DTO.MemberDTO;
import com.example.loginlayout.Entity.MemberEntity;
import com.example.loginlayout.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

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
        /*log.trace(); //추적
        log.warn();     //경고
        log.error();    //오류
        log.info()      //정보*/
        log.info("서비스(가입)-중복 아이디 검사");
        //아이디 중복을 확인
        memberRepository.findByUsername(memberDTO.getUsername())
                .ifPresent(member->{
                    throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
                });
        log.info("서비스(가입)-Entity변환");
        MemberEntity entity = modelMapper.map(memberDTO, MemberEntity.class);

        entity.setPassword(passwordEncoder.encode(memberDTO.getPassword()));//securityCofig작성수
        if(memberRepository.count()==0){
            entity.setRole(RoleType.ADMIN);
        }else if(memberRepository.count()==1){
            entity.setRole(RoleType.MANAGER);
        }else {
            entity.setRole(RoleType.USER);
        }

        log.info("서비스(가입)-데이터베이스에 저장");
        MemberEntity saved = memberRepository.save(entity);
        return modelMapper.map(saved, MemberDTO.class);

        //FixMe : 수정할 부분이 있는 곳에 주석
        //ToDO : 앞으로 작업할 부분에 주석


    }

    /**
     * ID로 회원 단건 조회
     * @param id 회원 고유번호
     * @return 회원 정보 DTO 또는 null
     */
    public MemberDTO findById(Long id) {
        log.info("서비스(개별조회)-조회");
        Optional<MemberEntity> memberEntity = memberRepository.findById(id);
        //MemberDTO memberDTO = modelMapper.map(memberEntity.get(), MemberDTO.class);

        log.info("서비스(개별조회)-조회결과 전달");
        return memberEntity.map(entity->
                modelMapper.map(entity, MemberDTO.class)).orElse(null);
    }

    /**
     * 전체 회원 조회
     * @return 회원 목록 DTO
     */
    public List<MemberDTO> findAll() {
        log.info("서비스(전체조회)-조회결과 전달");

        return memberRepository.findAll().stream().map(
                entity->modelMapper.map(entity, MemberDTO.class)
        ).collect(Collectors.toList());
    }

    /**
     * username으로 회원 조회
     * @param username 로그인용 사용자 이름
     * @return 회원 정보 DTO 또는 null
     */
    public MemberDTO findByUsername(String username) {
        log.info("서비스(아이디조회)-조회");
        Optional<MemberEntity> memberEntity = memberRepository.findByUsername(username);

        log.info("서비스(아이디조회)-결과전달");
        return memberEntity.map(entity->modelMapper.map(entity, MemberDTO.class))
                .orElse(null);
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
        log.info("서비스(수정)-조회");
        Optional<MemberEntity> memberEntity = memberRepository.findById(id);

        if(memberEntity.isPresent()){
            MemberEntity entity = memberEntity.get();

            entity.setFirstName(memberDTO.getFirstName());
            entity.setLastName(memberDTO.getLastName());
            //entity.setPassword(memberDTO.getPassword());
            entity.setPassword(passwordEncoder.encode(memberDTO.getPassword()));//securityCofig작성후 위코드를 현재로변경
            log.info("서비스(수정)-수정된 내용을 저장");
            MemberEntity update = memberRepository.save(entity);

            log.info("서비스(수정)-결과 전달");
            return modelMapper.map(update, MemberDTO.class);
        }
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
        log.info("서비스(삭제)-삭제대상조회");
        if(memberRepository.existsById(id)){
            log.info("서비스(삭제)-대상삭제");
            memberRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
