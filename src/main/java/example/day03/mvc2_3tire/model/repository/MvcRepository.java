package example.day03.mvc2_3tire.model.repository;

import org.springframework.stereotype.Repository;

@Repository //    : JPA 의 JDBC 기반의 DB 연동 라이브러러리
// @Mapper("")    : mybatis 의 JDBC 기반의 DB 연동 라이브러리
// @Component("") : Dao 의 단순 JDBC 클래스 -> 실무에서는 잘 사용하지 않음
// 실무에서는 @Repository 와 @Mapper 어노테이션 둘 다 사용 //
public interface MvcRepository {
}
