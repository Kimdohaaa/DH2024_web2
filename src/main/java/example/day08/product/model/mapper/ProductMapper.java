package example.day08.product.model.mapper;

import example.day08.product.model.dto.ProductDto;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductMapper {

    // [1] 제품등록
    @Insert("insert into day08product (pname, pprice, pexplain) values (#{pname}, #{pprice}, #{pexplain})")
    boolean write(ProductDto productDto);

    // [2] 제품 전체 조회
    @Select("select * from day08product")
    List<ProductDto> findAll();

    // [3] 제품 수정
    @Update("update day08product set pname = #{pname}, pprice= #{pprice}, pexplain = #{pexplain} where pno = #{pno}")
    boolean update(ProductDto productDto);

    // [4] 제품 삭제
    @Delete("delete from day08product where pno = #{pno}")
    boolean delete(int pno);

    // [5] 제품 상세 조회
    @Select("select * from day08product where pno = #{pno}")
    ProductDto view(int pno);

}
