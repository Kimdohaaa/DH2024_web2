package example.day14._트랜잭션;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TranService {

    private final TranMapper tranMapper;

    // [1] 이름 등록
    @Transactional // 트랜젝션을 적용시키는 어노테이션
                   // @Transactional 발생조건 : RuntimeException
                   // => 해당 메소드에서 실행하는 SQL 에서 RuntimeException 발생 시 모두 rollback 됨
    public boolean tran(){
        System.out.println("TranService.tran");
        // insert [1]
        tranMapper.tran("유재석");

        // 예외를 발생 시켜 [2] insert 가 안되게 하기
        if(true) {
            // 예외 발생 시 아래 코드 실행 X (유재석만 저장됨)
            throw new RuntimeException("강제로 실행 예외 발생 시키기");
            // 만약 두개의 insert 를 실행하는 도중에 insert [1] 이후 예외 발생 시 두번째 insert [2] 실행 불가
            // @Transactional 어노테이션 주입 시 유재석도 rollback 됨
        }

        // insert [2]
        tranMapper.tran("강호동");

        return true;
    }

    // [2] 트랜잭션을 이용한 이체 로직
    @Transactional(rollbackFor = Exception.class)
            // rollbackFor = Exception.class : 모든 예외 클래스에 대한 롤백이 적용됨
    public boolean transfer(Map<String, String> params) throws  Exception{
        System.out.println("TranService.transfer");
        System.out.println("params = " + params);

        // 예외처리방법_1 : try-catch 문 사용
        // 예외처리방법_2 : throw 로 예외던지기


        // 예제] "서장훈" 이 "신동엽" 에게 10만원 이체 //
        int money = Integer.parseInt(params.get("money")); // 출금 금액
        // 1) 보내는 사람의 금액 차감
        String fromName = params.get("fromName"); // 보내는 사람
        tranMapper.withdraw(fromName, money); // Mapper 클래스 출금 메소드

        // 2) 받는 사람의 금액 추가
        String toName = params.get("toName"); // 받는 사람
        tranMapper.deposit(toName , money); // Mapper 클래스 입금 메소드


        return  true;
    }

    // [3] 매일 9시 회원들에게 100원씩 입급
    @Scheduled(cron = "0 */1 * * * *") // 매일 9시 스케쥴링
    @Transactional(rollbackFor = Exception.class) // 해당하는 메소드에서 예외 발생 시 모든 SQL 취소, 롤백
    public void Task() throws  Exception{ // 예외 던지기
        // 1) 모든 회원 목록

        // 스트림, 람다식, 레퍼런스 적용 버전 //
        tranMapper.findAll() // 모든 회원목록 조회
                .stream()    // 조회 결과 스트림 생성
                // .forEach((name) -> tranMapper.deposit(name, 100)); // 스트림의 회원들에게 100원씩 입금
                .filter(name -> !name.equals("유재석")) // 조건
                .forEach(this::depositAll); // 메소드 레퍼런스 적용 | this : 현재 스트립에서 각 데이터의 이름

        // 일반적인 방법 //
        List<String> names = tranMapper.findAll(); // 모든 회원목록 조회
        for(int i = 0; i <= names.size(); i++){ // 조회한 회원목록 순회
            String name = names.get(i); // 각 회원의 이름 가져오기
            if(!name.equals("유재석")) continue; // 조건
            tranMapper.deposit(name, 100); // 입금 처리
        }

        System.out.println(">> 모든 회원들에게 100원씩 입금 처리 완료");

    }

    // [4] 메소드 레퍼런스 적용을 위한 메소드 선언
    private void depositAll(String name){
        tranMapper.deposit(name, 100);
    }
}
