package example.day04._2day04과제.model.mapper;

import example.day04._2day04과제.model.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Insert("INSERT INTO board (title, content) VALUES (#{title}, #{content})")
    boolean add(BoardDto boardDto);

    @Select("select * from board")
    List<BoardDto> findAll();

    @Select("SELECT * FROM board WHERE bno = #{bno}")
    BoardDto find(int bno);

    @Update("UPDATE board SET title = #{title}, content = #{content} WHERE bno = #{bno}")
    boolean update(BoardDto boardDto);

    @Delete("DELETE FROM board WHERE bno = #{bno}")
    boolean delete(int bno);
}
