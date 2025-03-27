package example.day14;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TranMapper {

    // 이름 등록
    @Insert("insert into day13users(name) values (#{name})")
    boolean tran(String name);
}
