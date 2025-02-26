package example.day05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
        // 서버 시작시 schema.sql 파일과 data.sql 에 작성한 DB 코드가 자동 실행됨
        // => MySQL Workbench 에서 확인가능!
    }
}
