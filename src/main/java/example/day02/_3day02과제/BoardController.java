package example.day02._3day02과제;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // @ResponseBody 가 포함되어 있음
@RequestMapping("/day02/task1/board")
public class BoardController {

    // DB 대신 사용할 LIST 생성
    List<BoardDto> list = new ArrayList<>();
    // bno 를 자동 증가 시킬 변수 선언
    int count = 0;

    // [1] 글 쓰기
    @PostMapping
    public boolean write(@RequestBody BoardDto boardDto){ // 요청값 HTTP BODY
        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);

        // 요청값이 존재하면 list 에 add
        if(boardDto != null) {
            boardDto.setBno(++count); // bno 증가

            count = boardDto.getBno(); // 다음 입력 시를 위해 count 값 변경

            System.out.println(count); // 증가 확인
            System.out.println(boardDto.getBno()); // 증가확인

            list.add(boardDto); // list 에 요청값 add

            return true; // 성공 시 true 반환
        }

        return false; // 실패 시 false 반환
    }

    // [2] 전체 글 조회
    @GetMapping
    public List<BoardDto> findAll(){
        System.out.println("BoardController.findAll");

        return  list; // 전역변수 list 반환 (@ResponseBody 는 @RestController 에 포함되어있으므로 생략)
    }

    // [3] 개별 글 조회
    @GetMapping("/view")
    public  BoardDto find(@RequestParam int bno){ // 요청값 쿼리스트링
        System.out.println("BoardController.find");
        System.out.println("bno = " + bno);

        // 배열 순회를 통해 list 내에 있는 요청값과 같은 bno 찾기
        for(BoardDto i : list){
            if(i.getBno() == bno){ // 만약 list 의 i 번째 bno 와 요청값 bno 가 같다면
                return i; // i 번째 boardDto 반환
            }
        }

        return null; // 찾지 못할 시 null 반환
    }

    // [4] 개별 글 수정
    @PutMapping
    public boolean update(@RequestBody BoardDto boardDto){ // 요청값 HTTP BODY
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);

        // 배열 순회를 통해 list 내에 있는 요청값과 같은 bno 찾기
        for(BoardDto j : list){
            if(j.getBno() == boardDto.getBno()){ // 만약 list 의 j 번째 bno 와 요청값 bno 가 같다면
                j.setTitle(boardDto.getTitle()); // Setter 을 통해 j 번째 title 변경
                j.setContent(boardDto.getContent()); // Setter 을 통해 j 번째 content 변경
                return true; // true 반환
            }
        }

        return false; // 찾지 못할 시 false 반환
    }

    // [5] 개별 글 삭제
    @DeleteMapping
    public boolean delete(@RequestParam int bno){ // 요청값 쿼리스트링
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);

        // 배열 순회를 통해 list 내에 있는 요청값과 같은 bno 찾기
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getBno() == bno){ // 만약 list 의 i 번째 bno 와 요청값 bno 가 같다면
                list.remove(i); // i 번째 boardDto 삭제
                return true; // true 반환
            }
        }

        return false; // 찾지 못할 시 false 반환
    }
}
