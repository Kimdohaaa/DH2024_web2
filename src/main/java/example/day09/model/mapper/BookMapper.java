package example.day09.model.mapper;

import example.day09.model.dto.BookDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    // [1] 추천 등록
    @Insert("insert into suggest (bname, bcontent, bpwd) values (#{bname}, #{bcontent}, #{bpwd})")
    boolean write(BookDto bookDto);

    // [2] 추천 수정
    @Update("update suggest set bname= #{bname} , bcontent = #{bcontent} where bno = #{bno} and bpwd = #{bpwd}")
    boolean update(BookDto bookDto);

    // [3] 추천 삭제
    @Delete("delete from suggest where bno= #{bno} and bpwd = #{bpwd}")
    boolean delete(BookDto bookDto);

    // [4] 추천 전체 조회
    @Select(("select * from suggest"))
    List<BookDto> findAll();

    // [5] 추천 상세 조회
    @Select("select * from suggest where bno = #{bno}")
    BookDto find(int bno);
}
