package example.day02._1RESTparam;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/day02")
public class RestController4 {

    // [1] HTTP Request Body 매핑 방법 (POST / PUT)
    // ★ 주의점 : @RequestBody 생략 시 @ModelAttribute 가 자동 주입 되므로 반드시 명시해야함 ★ //

    // 1) DTO 로 Request 받기
    @PostMapping("/dopost1")
    public boolean method1(@RequestBody MemberDto memberDto){
        System.out.println("RestController4.method1");
        System.out.println("memberDto = " + memberDto);

        return true;
    }

    // 2) 컬렉션 프레임워크 (MAP) 으로 Request 받기
    @PostMapping("/dopost2")
    public boolean method2(@RequestBody Map<String,String> map){
        System.out.println("RestController4.method2");
        System.out.println("map = " + map);

        return true;
    }
}
