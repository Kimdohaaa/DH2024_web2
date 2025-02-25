package example.day04._2day04과제.service;

import example.day04._2day04과제.model.dto.BoardDto;
import example.day04._2day04과제.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    public boolean add(BoardDto boardDto){
        System.out.println("BoardService.add");
        System.out.println("boardDto = " + boardDto);

        boolean result = boardMapper.add(boardDto);
        return result;
    }

    public List<BoardDto> findAll(){
        System.out.println("BoardService.findAll");

        List<BoardDto> result = boardMapper.findAll();
        return result;
    }

    public BoardDto find(int bno){
        System.out.println("BoardService.findById");
        System.out.println("bno = " + bno);

        BoardDto result = boardMapper.find(bno);
        return result;
    }

    public boolean update(BoardDto boardDto){
        System.out.println("BoardService.update");
        System.out.println("boardDto = " + boardDto);

        boolean result = boardMapper.update(boardDto);
        return result;
    }

    public boolean delete(int bno){
        System.out.println("BoardService.delete");
        System.out.println("bno = " + bno);

        boolean result = boardMapper.delete(bno);
        return result;
    }
}
