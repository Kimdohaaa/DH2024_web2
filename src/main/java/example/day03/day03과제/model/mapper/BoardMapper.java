package example.day03.day03과제.model.mapper;

import example.day03.day03과제.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // [1] 등록
    boolean write(BoardDto board);
    // [2] 전체 출력
    List<BoardDto> findAll();
    // [3] 개별 출력
    BoardDto find(int bno);
    // [4] 수정
    boolean update(BoardDto board);
    // [5] 삭제
    boolean delete(int bno);
}
