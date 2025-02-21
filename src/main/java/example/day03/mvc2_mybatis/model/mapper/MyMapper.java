package example.day03.mvc2_mybatis.model.mapper;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// Dao 역할
// 인터페이스로 생성하기

@Mapper
public interface MyMapper {

    // Service 에게 받은 데이터를 XML 파일에 매개변수로 보내 SQL 처리
    int save(MyDto myDto); // 추상 메소드로 매핑 구현

    // Service 에게 받은 데이터를 XML 파일에 매개변수로 보내 SQL 처리
    List<MyDto> findAll(); // 추상 메소드로 매핑 구현

    // Service 에게 받은 데이터를 XML 파일에 매개변수로 보내 SQL 처리
    MyDto find(int id);

    // Service 에게 받은 데이터를 XML 파일에 매개변수로 보내 SQL 처리
    int update(MyDto myDto); // 추상 메소드로 매핑 구현

    // Service 에게 받은 데이터를 XML 파일에 매개변수로 보내 SQL 처리
    int delete(int id); // 추상 메소드로 매핑 구현
}
