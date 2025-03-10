package example.day07.board.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController // 빈 등록
@RequestMapping("/day07/react") // 공동 URL 지정
@CrossOrigin("http://localhost:5181") // 특정 URL 만 가능하도록 CORS 정책을 허용
public class ReactController {

    List<Map<Object, String>> boards = new ArrayList<>();

    // [1] POST 매핑
    @PostMapping
    public boolean onPost (@RequestBody Map<Object, String> map){
        System.out.println("ReactController.onPost");
        System.out.println("map = " + map);

        boards.add(map);

        return true;
    }

    // [2] GET 매핑
    @GetMapping
    public List<Map<Object, String>> onFindALl(){
        return boards;
    }
}
