package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

import java.sql.Struct;

@Service
@RequiredArgsConstructor // final 멤버변수에 대한 생성자 자동 지원 => @Autowired 생략 가능
public class MemberService {

    // @RequiredArgsConstructor 를 통해 @Autowired 어노테이션 생략
    private  final MemberMapper memberMapper;

    private final FileService fileService;

    // [1] 회원가입
    public  boolean signup(MemberDto memberDto){
        System.out.println("memberDto = " + memberDto);
        System.out.println("MemberService.signup");
        try {
            // 1) 첨부파일(프로필)이 존재하는 검사
            if (memberDto.getUploadfile() == null) { // 만약 업로드가 존재하지 않으면

            } else { // 만약 업로드가 존재하면
                // 2) 업로드 로직을 처리하는 메소드를 통해 첨부파일 업로드 후 파일명 반환받기
                String fileName = fileService.fileUpload(memberDto.getUploadfile());
                System.out.println("파일명 : " + fileName);
                // 3) 업로드된 파일명 MemberDto 에 저장
                memberDto.setMimg(fileName);
                System.out.println("set 파일명 : " + memberDto.getMimg());
            }

            // 4) 비크립트 알고리즘 라이브러리를 이용한 비밀번호 암호화

            // 4-1) 비크립트 객체 생성
            BCryptPasswordEncoder BMpwd = new BCryptPasswordEncoder();

            // 4-2) 암호화
            //  => .encode(암호화할 자료)
            String hashedPassword = BMpwd.encode(memberDto.getMpwd());

            System.out.println("hashedPassword = " + hashedPassword);

            // 4-3) 암호화된 값을 DTO 에 넣어서 DB 처리
            memberDto.setMpwd((hashedPassword));

            // ★ 비크립트는 복호화 불가 / 비밀번호 검증 시 해시값으로 검증함 ★ //

            System.out.println(memberDto);

            return memberMapper.signup(memberDto);
        }catch (Exception e){
            return  false; // 업로드된 회원가입 DB 처리 중 예외 발생 시 false 반환
        }
    }

    // [2] 로그인
    public MemberDto login(MemberDto memberDto){
        System.out.println("MemberService.login");
        System.out.println("memberDto = " + memberDto);

        // 암호화된 진짜 비밀번호는 DB 에 존재 / 로그인에 사용된 비밀번호는 암호화하기 전 //
        // DB 에서 select 를 통해 로그인 검증 시 암호화된 비밀버호 != 로그인 시 입력한 비밀번호이므로 검증 불가
        //

        // [1] 로그인 시 입력받은 아이디에 해당되는 암호화된 비밀번호 가져오기
        String password = memberMapper.findPassword(memberDto.getMid());

        // [2] 해당 아이디 존재 여부 검사
        if(password == null){
            return  null;
        }

        // [3] 해당 아이디 존재 시 로그인 시 입력받은 비밀번호화 암호화된 비밀번호 검증
        // *) 비클립트 객체 생성
        BCryptPasswordEncoder BMpwd = new BCryptPasswordEncoder();

        // *) 비밀번호 검증
        // 비클립트 객체명.matches(비교할 자료, 암호화된 자료) => true / false 로 반환
        boolean result = BMpwd.matches(memberDto.getMpwd(), password);

        // *) 검증 결과에 따른 처리
        if(result == false){ // 비밀번호 검증 실패
            return  null; // null 반환
        }

        // 비밀번호 검증 성공 시 DB 에서 해당 아이디의 정보 반환받기
        MemberDto memberDto1 = memberMapper.login(memberDto);

        return memberDto1;
    }
}
