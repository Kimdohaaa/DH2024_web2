package example.day03.day03과제.controller;

import example.day03.day03과제.model.dto.BoardDto;
import example.day03.day03과제.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // IOC(제어의 역전) : 컨테이너(메모리)에 bean 주입
@RequestMapping("/day03/task/board") // @RequestMapper 어노테이션을 통해 공통 URL 정의
public class BoardController {

    // @Autowired 를 통해 컨테이너에 등록된 bean 주입 -> boardService 호출
    @Autowired
    BoardService boardService;

    // [1] 등록
    @PostMapping
    public boolean write(@RequestBody BoardDto boardDto){ // HTTP BODY Request 값 받기
        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);

        // Service 로 전달 , 반환받기
        boolean result = boardService.write(boardDto);
        return result;
    }

    // [2] 전체 출력
    @GetMapping
    public List<BoardDto> findAll(){
        System.out.println("BoardController.findAll");

        // Service 로 전달 , 반환받기
        List<BoardDto> result = boardService.findAll();
        return result;
    }

    // [3] 개별 글 출력
    @GetMapping("/view")
    public BoardDto find(@RequestParam("bno") int bno){ // 쿼리스트링 Request 값 받기
        System.out.println("BoardController.find");
        System.out.println("bno = " + bno);

        // Service 로 전달 , 반환받기
        BoardDto result = boardService.find(bno);
        return result;
    }

    // [3] 글 수정
    @PutMapping
    public boolean update(@RequestBody BoardDto boardDto){ // HTTP BODY Request 값 받기
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);

        // Service 로 전달 , 반환받기
        boolean result = boardService.update(boardDto);
        return result;
    }

    // [4] 글 삭제
    @DeleteMapping
    public boolean delete(@RequestParam("bno") int bno){ // 쿼리스트링 Request 값 받기
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);

        // Service 로 전달 , 반환받기
        boolean result = boardService.delete(bno);
        return result;
    }
}
