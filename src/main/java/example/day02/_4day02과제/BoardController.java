package example.day02._4day02과제;


import example.day02._3day02과제.BoardDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController // @ResponseBody 가 포함되어 있음
@RequestMapping("/day02/task2/board")
public class BoardController {

    @Autowired
    BoardDao BoardDao;


    @PostMapping
    // 1. 게시물 쓰기 제어 함수
    public boolean create(@RequestBody BoardDto boardDto ) {
        // [1] 매개변수로 받은 값들을 DAO에게 전달하여 처리결과를 요청하고 받는다.
        boolean result = BoardDao.create( boardDto );
        // [2] 처리 결과를 VIEW에게 반환한다.
        return result;
    }

    @GetMapping
    // 2. 게시물 출력 제어 함수
    public ArrayList<BoardDto> readAll(){
        // [1] DAO에게 처리 결과를 요청하고 받는다.
        ArrayList<BoardDto> result = BoardDao.readAll();
        // [2] 처리 결과를 VIEW에게 반환한다.
        return result;
    }

    @GetMapping("/view")
    // 2. 게시물 출력 제어 함수
    public BoardDto read(@RequestParam int bno ){
        // [1] DAO에게 처리 결과를 요청하고 받는다.
        BoardDto result = BoardDao.read(bno);
        // [2] 처리 결과를 VIEW에게 반환한다.
        return result;
    }
    @PutMapping
    // 3. 게시물 수정 제어 함수
    public boolean update(@RequestBody BoardDto boardDto ) {
        // [1] 매개변수 받은 값들을 DAO에게 전달하고 처리 결과를 받는다.
        boolean result = BoardDao.update( boardDto );
        // [2] VIEW 에게 결과를 반환한다.
        return result;
    }

    @DeleteMapping
    // 4. 게시물 삭제 제어 함수
    public boolean delete(@RequestParam int bno ) {
        // [1] 매개변수 받은 값들을 DAO에게 전달하고 처리 결과 를 받는다.
        boolean result = BoardDao.delete(bno);
        // [2] VIEW에게 결과를 반환한다.
        return result;
    }

}