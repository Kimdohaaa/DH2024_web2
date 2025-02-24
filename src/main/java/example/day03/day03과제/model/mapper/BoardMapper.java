package example.day03.day03과제.model.mapper;

import example.day03.day03과제.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // IOC(제어의 역전) : 컨테이너(메모리)에 bean 주입
public interface BoardMapper {

    // XML 소스파일에서 DB 와 매핑할 추상메소드 //
    // [1] 등록 -> Service 가 매개변수로 전달한 값 DB 와 매핑 후 결과 반환
    boolean write(BoardDto board);
    // [2] 전체 출력 -> Service 가 매개변수로 전달한 값 DB 와 매핑 후 결과 반환
    List<BoardDto> findAll();
    // [3] 개별 출력 -> Service 가 매개변수로 전달한 값 DB 와 매핑 후 결과 반환
    BoardDto find(int bno);
    // [4] 수정 -> Service 가 매개변수로 전달한 값 DB 와 매핑 후 결과 반환
    boolean update(BoardDto board);
    // [5] 삭제 -> Service 가 매개변수로 전달한 값 DB 와 매핑 후 결과 반환
    boolean delete(int bno);
}
