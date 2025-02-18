package example.day02._1RESTparam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Member;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/day02")
public class RestController {

    // [1] HTTP Servlet 내장 객체(요청/응답) : HttpServletRequest , HttpServletResponse 지원 => 기존 방식
    @GetMapping
    public void mehtod1(HttpServletRequest req , HttpServletResponse res) throws  Exception{

        // 서블릿 방식의 쿼리스트링 Request 값 받기
        System.out.println("RestController.mehtod1"); // soutm : 현재 함수명 출력 함수
        String name =  req.getParameter("name");
        System.out.println("name = " + name);         // soutv : 가장 가까운 변수 출력 함수

        // 서블릿 방식의 Response 하기
        res.setContentType("application/json");
        res.getWriter().println(true);
    }

    // [2] Spring 에서 제공하는 방법 !!!더 간단!!!
    @GetMapping("/doget2")
    public boolean method2(@RequestParam(name = "name", defaultValue = "홍길동", required = true) String name){
                         // @RequestParam (생략 가능) : 매핑함수의 매개변수를 자동으로 쿼리스트링의 매개변수로 매핑함
                         // @RequestParam(name = "")
                         // @RequestParam(defaultValue= "") : 쿼리스트링에 매핑할 값이 없을 시 default 값 지정
                         // @RequestParam(required = false) : 쿼리스트링 매개변수 필수여부 설정 (기본값 : true)

        System.out.println("RestController.method2");
        System.out.println("name = " + name); // soutp : 현재 함수의 매개변수 출력함수
        return true; // @ResponseBody  사용 시 자동으로 response 를 "application/json" 타입으로 응답함
    }

    // [2-1] 기본타입을 이용한 쿼리스트링 매개변수 매핑
    @GetMapping("/doget3")
    public int method3(@RequestParam String name , @RequestParam int age){
                       // 자동 형 변환됨
        System.out.println("RestController.method3"); // soutm : 메소드 자동완성
        System.out.println("name = " + name + ", age = " + age);

        return 3;
    }

    // [2-2] 컬렉션 프레임워크를 이용한 쿼리스트링 매개변수 매핑 (쿼리스트링 여러개의 매개변수를 하나의 MAP 으로 받기)
    @GetMapping("/doget4")
    public String method4(@RequestParam Map<String,String> map){
        System.out.println("RestController.method4");
        System.out.println("map = " + map);

        return  "hello";
    }


    // [2-3] DTO 를 이용한 쿼리스트링 매개변수 매핑 (쿼리스트링 여러개의 매개변수를 하나의 DTO 으로 받기)
    // ★ 주의점 : DTO 사용 시 쿼리스트링 매개변수와 멤버변수명이 동일해야 함 ★ //
    @GetMapping("/doget5")
    public boolean method5(MemberDto memberDto){ //@RequestParam 생략 -> @ModelAttribute 자동 주입
        System.out.println("RestController.method5");
        System.out.println("memberDto = " + memberDto);

        return  true;
    }


}
