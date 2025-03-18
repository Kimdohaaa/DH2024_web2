package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

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

        return memberMapper.login(memberDto);
    }
}
