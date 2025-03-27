package example.day14._트랜잭션;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TranMapper {

    // [1] 이름 등록
    @Insert("insert into day13users(name) values (#{name})")
    boolean tran(String name);

    // [2] 트랜잭션을 이용한 이체 로직
    // 1) 출금
    @Update("update day13users set money = money - #{money} where name = #{name}")
    boolean withdraw(String name, int money);

    // 2) 입금
    @Update("update day13users set money = money + #{money} where name = #{name}")
    boolean deposit(String name, int money);

    // [3] 매일 9시 회원들에게 100원씩 입급
    // 1) 모든 회원 목록 조회
    @Select("select name from day13users")
    List<String> findAll();

}

