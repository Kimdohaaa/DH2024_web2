package example.day01._3day01과제;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.Map;


@Controller
public class BoardController {

    // [1] 게시물 등록
    @PostMapping("/day01/task/board")
    @ResponseBody
    public boolean doPost() {
        return true;
    }

    // [2] 전체 글 출력
    @GetMapping("/day01/task/board")
    @ResponseBody
    public ArrayList<Map<String,String>> doGet1() {

        ArrayList<Map<String,String>> list = new ArrayList<>();

        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
        list.add( map1 );
        Map<String,String> map2 = new HashMap<>();
        map2.put("bno" , "2" );
        map2.put("btitle" , "제목2");
        list.add( map2 );

        return list;
    }

    // [3] 개별 글 조회
    @GetMapping("/day01/task/board/view")
    @ResponseBody
    public Map<String, String> doGet2() {
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");

        return map1;
    }

    // [4] 개별 글 수정
    @PutMapping("/day01/task/board")
    @ResponseBody
    public boolean doPut() {
        return true;
    }

    // [5] 개별 글 삭제
    @DeleteMapping("/day01/task/board")
    @ResponseBody
    public int doDelete() {
        return 1;
    }



}
