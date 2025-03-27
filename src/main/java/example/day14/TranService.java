package example.day14;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TranService {

    private final TranMapper tranMapper;

    // 이름 등록
    @Transactional // 트랜젝션을 적용시키는 어노테이션
                   // @Transactional 발생조건 : RuntimeException
                   // => 해당 메소드에서 실행하는 SQL 에서 RuntimeException 발생 시 모두 rollback 됨
    public boolean tran(){
        System.out.println("TranService.tran");
        // [1] 첫번째 insert
        tranMapper.tran("유재석");

        // 예외를 발생 시켜 [2] insert 가 안되게 하기
        if(true) {
            // 예외 발생 시 아래 코드 실행 X (유재석만 저장됨)
            throw new RuntimeException("강제로 실행 예외 발생 시키기");
            // 만약 두개의 insert 를 실행하는 도중에 첫번째 insert 이후 예외 발생 시 두번째 insert 싫애 불가
            // @Transactional 어노테이션 주입 시 유재석도 rollback 됨
        }

        // [2] 두번째 insert
        tranMapper.tran("강호동");

        return true;
    }
}
