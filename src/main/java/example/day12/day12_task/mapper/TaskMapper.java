package example.day12.day12_task.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TaskMapper {
    // [1] 매 30 초마다 제품의 재고는 3개씩 감소
    @Update("update day11products SET stock_quantity = stock_quantity - 3")
    void task1();
    // [2] 매 1분마다 모든 제품정볼르 조회하여 console에 출력
    @Select("select * from day11products")
    List<HashMap<String, String>> task2();
    // [3] 매 5분마다 재고가 10이하인 상품의 재고를 20개 추가
    @Update("update day11products SET stock_quantity = stock_quantity + 20 WHERE stock_quantity < 10")
    public void task3();
}
