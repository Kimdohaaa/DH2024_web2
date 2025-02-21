package example.day03.day03과제.service;

import example.day03.day03과제.model.dto.BoardDto;
import example.day03.day03과제.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    // [1] 글 등록
    public boolean write(BoardDto boardDto){
        System.out.println("BoardService.write");
        System.out.println("boardDto = " + boardDto);

        boolean result = boardMapper.write(boardDto);
        return result;
    }

    // [2] 전체 글 출력
    public List<BoardDto> findAll(){
        System.out.println("BoardService.list");

        List<BoardDto> result = boardMapper.findAll();
        return result;
    }

    // [3] 개별 글 조회
    public BoardDto find(int bno){
        System.out.println("BoardService.read");
        System.out.println("bno = " + bno);

        BoardDto result = boardMapper.find(bno);
        return result;
    }

    // [4] 글 수정
    public boolean update(BoardDto boardDto){
        System.out.println("BoardService.update");
        System.out.println("boardDto = " + boardDto);

        boolean result = boardMapper.update(boardDto);
        return result;
    }

    // [5] 글 삭제
    public boolean delete(int bno){
        System.out.println("BoardService.delete");
        System.out.println("bno = " + bno);

        boolean result = boardMapper.delete(bno);
        return result;
    }
}
