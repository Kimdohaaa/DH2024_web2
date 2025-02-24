package example.day03.day03과제.service;

import example.day03.day03과제.model.dto.BoardDto;
import example.day03.day03과제.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // IOC(제어의 역전) : 컨테이너(메모리)에 bean 주입
public class BoardService {

    // @Autowired 를 통해 컨테이너에 등록된 bean 주입 -> boardMapper 호출
    @Autowired
    BoardMapper boardMapper;

    // [1] 글 등록
    public boolean write(BoardDto boardDto){ // controller 가 전달한 Request 값
        System.out.println("BoardService.write");
        System.out.println("boardDto = " + boardDto);

        boolean result = boardMapper.write(boardDto);
        return result;
    }

    // [2] 전체 글 출력
    public List<BoardDto> findAll(){
        System.out.println("BoardService.list");

        // Mapper 로 전달 , 반환받기
        List<BoardDto> result = boardMapper.findAll();
        return result;
    }

    // [3] 개별 글 조회
    public BoardDto find(int bno){ // controller 가 전달한 Request 값
        System.out.println("BoardService.read");
        System.out.println("bno = " + bno);

        // Mapper 로 전달 , 반환받기
        BoardDto result = boardMapper.find(bno);
        return result;
    }

    // [4] 글 수정
    public boolean update(BoardDto boardDto){ // controller 가 전달한 Request 값
        System.out.println("BoardService.update");
        System.out.println("boardDto = " + boardDto);

        // Mapper 로 전달 , 반환받기
        boolean result = boardMapper.update(boardDto);
        return result;
    }

    // [5] 글 삭제
    public boolean delete(int bno){ // controller 가 전달한 Request 값
        System.out.println("BoardService.delete");
        System.out.println("bno = " + bno);

        // Mapper 로 전달 , 반환받기
        boolean result = boardMapper.delete(bno);
        return result;
    }
}
