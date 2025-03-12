package example.day09.model.mapper;

import example.day09.model.dto.ReviewDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewMapper {

    // [1] 리뷰 등록
    @Insert("insert into review (rcontent , rpwd, bno) values (#{rcontent}, #{rpwd}, #{bno})")
    boolean write(ReviewDto reviewDto);

    // [2] 리뷰 조회
    @Select("select r.*, s.bname from review r join suggest s on r.bno = s.bno")
    List<ReviewDto> findAll();

    // [3] 리뷰 삭제
    @Delete("delete from review where rno= #{rno} and rpwd= #{rpwd}")
    boolean delete(ReviewDto reviewDto);
}
