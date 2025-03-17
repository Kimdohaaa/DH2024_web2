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


    // [1] 회원가입 (첨부파일X)
    public  boolean signup(MemberDto memberDto){
        System.out.println("memberDto = " + memberDto);
        System.out.println("MemberService.signup");

        return  memberMapper.signup(memberDto);
    }

    // [2] 로그인
    public MemberDto login(MemberDto memberDto){
        System.out.println("MemberService.login");
        System.out.println("memberDto = " + memberDto);

        return memberMapper.login(memberDto);
    }
}
