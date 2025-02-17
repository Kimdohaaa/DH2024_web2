package example.day01._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
// 1. Spring Controller 에 bean 등록
// 2. HTTP Servlet 지원 -> 상속 불필요

// @Controller(view 반환) vs @RestController(값 반환) //
// @RestController 어노테이션 사용 시 메소드 위에 @ResponseBody 어노테이션 생략가능
public class RestController2 {

    // @ResponseBody //
    // [1] int
    @GetMapping("/day01/doget3")
    @ResponseBody // int : 자동으로 함수 return 값을  application/json 타입 으로 응답
    public int doGet3() {
        return 100;
    }

    // [2] String
    @GetMapping("/day01/doget4")
    @ResponseBody // String : 자동으로 함수 return 값을 text/plain 타입으로 응답
    public String doGet4() {
        return "안녕 나는 스프링이야";
    }

    // [3] Map
    @GetMapping("/day01/doget5")
    @ResponseBody // 자동으로 함수 return 값을  application/json 타입 으로 응답
    public Map<String,String> doGet5() {
        Map<String,String> map = new HashMap<>();
        map.put("name", "강호동");
        return map;
    }

    // [4] boolean
    @GetMapping("/day01/doget6")
    @ResponseBody // 자동으로 함수 return 값을  application/json 타입 으로 응답
    public boolean doGet6() {
        return true;
    }

    // @ResponseBody + @Controller => @RestController
}
