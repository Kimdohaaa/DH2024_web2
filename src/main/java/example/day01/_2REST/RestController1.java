package example.day01._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// [1] @Controller 어노테이션을 통해 해당 클래스가 Controller 임을 명시 , 어노테이션 기능 주입
// -> 해당 클래스는 Spring 컨테이너(메모리) bean(객체) 를 등록
// -> Spring Controller 는 기본적으로 HTTP Servlet 을 지원하기 때문에 별도의 상속이 불필요
@Controller
public class RestController1 {

    // [2] @RequestMapping(value = "HTTP 주소", method = RequestMethod.사용할 HTTP 메소드)
    // -> value 속성에 매핑할 HTTP 주소를 정의 ☆ 프로젝트명 생략 ☆
    // -> method = RequestMethod. 사용할 HTTP 메소드 (POST, GET , PUT , DELETE)

    // 방법 1 //
    // [2-1] GET 메소드 매핑
    @RequestMapping(value = "/day01/doget", method = RequestMethod.GET)
    public void doGet() {
        System.out.println("day01_doGet METHOD");

    }

    // [2-2] POST 메소드 매핑
    @RequestMapping(value = "day01/dopost", method = RequestMethod.POST)
    public void doPost() {
        System.out.println("day01_doPost METHOD");
    }

    // [2-3] PUT 메소드 매핑
    @RequestMapping(value = "/day01/doput" , method = RequestMethod.PUT)
    public void doPut() {
        System.out.println("day01_doPut METHOD");
    }

    // [2-4] DELETE 메소드 매핑
    @RequestMapping(value = "/day01/dodelete", method = RequestMethod.DELETE)
    public void doDelete() {
        System.out.println("day01_doDelete METHOD");
    }


    // 방법 2 //
    // [2-1] GET 메소드 매핑
    @GetMapping("/day01/doget2")
    public void doGET2() {
        System.out.println("day01_doGet2 METHOD");
    }

    // [2-2] POST 메소드 매핑
    @PostMapping("day01/dopost2")
    public void doPost2() {
        System.out.println("day01_doPost2 METHOD");
    }

    // [2-3] PUT 메소드 매핑
    @PutMapping("day01/doput2")
    public void doPut2() {
        System.out.println("day01_doPut2 METHOD");
    }

    // [2-4] DELETE 메소드 매핑
    @DeleteMapping("day01/dodelete2")
    public void doDelete2() {
        System.out.println("day01_doDelete2 METHOD");
    }
}
