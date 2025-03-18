package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

@RestController // @ResponseBody 를 포함하고 RestAPI 를 지우너하는 컨트롤러 빈 등록 어노테이션
@RequestMapping("/api/member") // 공통 URL 매핑
/*
공통 URL 에 api 를 넣은 이유 (관례적 규칙)
-> 개발자들이 페이지 매핑과 REST 매핑을 구분하기 위해
-> 리액트 페이지 URL 과 REST URL 이 같으면 충돌 발생
1. 페이지 URL : /member/signup
2. REST URL
    1) /member/signup.do    => 과거
    2) /api/member/signup   => 요즘
*/
@RequiredArgsConstructor // @RequiredArgsConstructor : final 멤버변수에 생성자를 자동으로 지원하는 어노테이션
                         //  => @Autowired 를 통한 생성자 의존성 주입 생략 가능
public class MemberController {

    // @RequiredArgsConstructor 어노테이션 주입에 의해 @Autowired 를 통한 생성자에 의존성 주입 생략
    private  final MemberService memberService;

    // [1] 회원가입 (첨부파일X)
    @PostMapping("/signup")
    public boolean signup(MemberDto memberDto){ // 프로필 이미지를 요청받기 위해 Content-Type 을 multipart/form-data 로 받음
                // "multipart/form-data" 타입으로 요청을 받을 때는 @RequestBody 생략 => @ModelAttribute 자동 적용
        System.out.println("MemberController.signup");
        System.out.println("memberDto = " + memberDto);

        return  memberService.signup(memberDto);
    }

    // [2] 로그인
    @PostMapping("/login")
    public boolean login(@RequestBody MemberDto memberDto, HttpServletRequest req){
                           // + 세션(서버 내 저장소) 사용을 위해 HttpServletRequest 객체 매개변수로 받기
        System.out.println("MemberController.login");
        System.out.println("memberDto = " + memberDto);

        MemberDto result = memberService.login(memberDto);

        if(result == null){ // 존재하지 않는 정보로 DB 반환 값이 null 이면
            return  false;  // 로그인 실패
        }else {             // 존재하는 정보로 DB 반환 값이 존재하면

            // 세션에 로그인 성공한 DTO 저장 //
            // 1) 세션 호출
            HttpSession session = req.getSession();
            // 2) 로그인 성공한 DTO 를 session 에 저장 (key : loginDto)
            session.setAttribute("loginDto", result);
            // 3) 세션 유지 시간 지정
            session.setMaxInactiveInterval(60 * 10); // 10 분 지정

            // 로그인 성공 처리
            return  true;

        }
    }

    // [3] 로그아웃
    @GetMapping("/logout")
    public boolean logout(HttpServletRequest req){
        System.out.println("MemberController.logout");
        System.out.println("req = " + req);

        // 1) 세션 호출
        HttpSession session = req.getSession();
        if(session == null) {
            return false; // 세션이 없으면 false
        }else {

            // 2) 세션 내 특정 속성 초기화
            session.removeAttribute("loginDto");
            // 세션객체.invalidate() : 세션 내 전체 속성 초기화

            return true; // 세션 remove 성공 시 true
        }
    }

    // [4] 내정보 조회
    @GetMapping("/info")
    public MemberDto info(HttpServletRequest req){
        // 1) 세션 가져오기
        HttpSession session = req.getSession();

        if(session == null){ // 세션이 존재하지 않으면
            return  null;    // null 리턴
        }else {
            // 2) 세션 존재 시 세션 정보 꺼내오기
            Object object = (MemberDto)session.getAttribute("loginDto");

            // 3) 타입변환
            MemberDto memberDto = (MemberDto) object;

            // 4) 세션 정보 반환
            return memberDto;
        }

    }

    // [5]

}
