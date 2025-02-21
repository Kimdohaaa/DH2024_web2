package example.day03.day03과제.controller;

import example.day03.day03과제.model.dto.BoardDto;
import example.day03.day03과제.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day03/task/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    // [1] 등록
    @PostMapping
    public boolean write(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);

        boolean result = boardService.write(boardDto);
        return result;
    }

    // [2] 전체 출력
    @GetMapping
    public List<BoardDto> findAll(){
        System.out.println("BoardController.findAll");

        List<BoardDto> result = boardService.findAll();
        return result;
    }

    // [3] 개별 글 출력
    @GetMapping("/view")
    public BoardDto find(@RequestParam("bno") int bno){
        System.out.println("BoardController.find");
        System.out.println("bno = " + bno);

        BoardDto result = boardService.find(bno);
        return result;
    }

    // [3] 글 수정
    @PutMapping
    public boolean update(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);

        boolean result = boardService.update(boardDto);
        return result;
    }

    // [4] 글 삭제
    @DeleteMapping
    public boolean delete(@RequestParam("bno") int bno){
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);

        boolean result = boardService.delete(bno);
        return result;
    }
}
