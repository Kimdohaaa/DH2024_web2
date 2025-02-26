package example.day05.model.mapper;

import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface StudentMapper {

    // [1] 등록
    @Insert("insert into student (name, kor , math) values (#{name}, #{kor}, #{math})")
    @Options(useGeneratedKeys = true, keyProperty = "sno")
        // keyProperty = "대입할 PK 필드명" : 매개변수에 지한 필드명에 생성된 PK 값 지정
    int save(HashMap<String, Object> map);

    // [2] 전체조회
    // @Select("select * from student") : native 쿼리 (순수한 SQL 작성)
    @Select("<script> select * from student </script>") // 동적 쿼리 제공 (순수한 SQL 에 Mybatis 의 추가적인 쿼리 제공)
                                                        // => XML 형식
    List<Map<String, Object>> findAll();

    // 동적 쿼리 예시 => <script> <if>   //
    // [3] 특정한 점수 이상의 학생 조회 //
    // native 쿼리 : @Select("select * from student where kor >= 88 and math >= 88 ")
    // 동적 쿼리 :
    @Select("""
            <script> 
                select * from student
                where 1 = 1
                <if test= "minKor != null">
                    and kor >= #{minKor}
                </if>
                <if test = "minMath != null">
                    and math >= #{minMath}
                </if>
            </script>
            """)
            // 1 = 1( true ) : SQL 에서 자주 사용하는 조건으로 다음 조건을 동적으로 처리할 때 사용
            /*
             코드 해석
             1) minKor 가 null 일 때 SQL 실행 : select * from student where 1 = 1
             2) minKor 가 80 일 때 SQL 실행 : select * from student where 1 = 1 and kor >= 80
             3) minKor 가 88 이고 minMath 가 90 일 때 : select * from student where 1 = 1 and kor >= 80 and math >= 90
             4) minKor 가 null 이고 minMath 가 90 일 때 : select * from student where 1 = 1 and math >= 90
            */
    // """ 템플릿 (자바15 이상 부터 지원) : 큰따옴표 3개 사용 시 여러 줄 코드 작성 시 + 를 사용하지 않아도 다음 줄로 연결
    List<Map<String,Object>> findStudentScore(int minKor, int minMath);

    // [4] 개별 조회
    @Select("select * from student where sno = #{sno}" )
    Map<String, Object> view(int sno);

    // [5] 수정
    @Update("update student set name = #{name} , kor = #{kor}, math = #{math} where sno = #{sno}")
    int update(HashMap<String, Object> map);

    // [6] 삭제
    @Delete("delete from student where sno = #{sno}")
    boolean delete(int sno);

    // 동적쿼리 예시 => <foreach> //
    // [7] 한번에 여러 명의 학생 등록
    @Insert("""
            <script>    
                insert into student (name, kor , math)
                values
                <foreach collection="list" item="item" separator=",">
                    (#{item.name}, #{item.kor}, #{item.math})
                </foreach>
            </script>    
            """)
            /*
             코드해석
             <foreach collection="반복할리스트명" item="반복할변수명" separator="반복사이구분자">
             </foreach>
             list 라는 이름의 리스트를 item 이라는 변수로 반복하고 반복 사이를 "," 로 구분한다.
            */
    boolean saveAll(List<Map<String, Object>> list);

}
