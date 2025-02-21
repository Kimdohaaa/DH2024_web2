package example.day03.mvc2_mybatis.controller;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import example.day03.mvc2_mybatis.service.MyService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RestController : HTTP Servlet 매핑 지원 / @ResponseBody 가 포함된 어노테이션 / 컨테이너 bean 자동 등록
public class MyController {

    // @Autowired 어노테이션을 통해 Spring 컨테이너에서 Service 인스턴스 주입
    @Autowired
    private MyService myService;

    // Post 매핑
    @PostMapping("/day03/save")
    public int save(@RequestBody MyDto myDto) { // @RequestBody 를 통해 JSON 으로 Request 받기
        // soutm : 메소드 자동 출력
        System.out.println("MyController.save");
        // soutp : 매개변수 자동 출력
        System.out.println("myDto = " + myDto);

        // Controller 가 클라이언트로부터 Request 받은 데이터 -전달-> Service -반환-> Controller Response
        int result = myService.save(myDto);

        return  result;
    }

    // Get 매핑
    @GetMapping("/day03/findall")
    public List<MyDto> findAll() {
        System.out.println("MyController.findAll");

        // Controller 가 클라이언트로부터 Request 받은 데이터 -전달-> Service -반환-> Controller Response
        List<MyDto> result = myService.findAll();
        return  result;
    }

    @GetMapping("/day03/find")
    public MyDto find(@RequestParam("id")  int id){
        System.out.println("MyController.find");
        System.out.println("id = " + id);

        // Controller 가 클라이언트로부터 Request 받은 데이터 -전달-> Service -반환-> Controller Response
        MyDto result = myService.find(id);

        return  result;
    }

    // Put 매핑
    @PutMapping("/day03/update")
    public int update(@RequestBody MyDto myDto){
        System.out.println("MyController.update");
        System.out.println("myDto = " + myDto);

        // Controller 가 클라이언트로부터 Request 받은 데이터 -전달-> Service -반환-> Controller Response
        int result = myService.update(myDto);
        return result;
    }

    // Delete 매핑
    @DeleteMapping("/day03/delete")
    public int delete(@RequestParam("id") int id){
        System.out.println("MyController.delete");
        System.out.println("id = " + id);

        // Controller 가 클라이언트로부터 Request 받은 데이터 -전달-> Service -반환-> Controller Response
        int result = myService.delete(id);
        return  result;
    }
}
