package example.day06.aop;

// AOP 없이 구현된 코드 //
// AOP : 여러 메소드에서 중복되는 코드들을 공통 기능으로 분리하여 필요 시 자동으로 실행
class TestService {
    // 메소드_1
    public void enter1(){
        System.out.println("[코로나] 온도 체크 => 보안"); // [1]
        System.out.println("식당 입장");         // [2]
        // 비즈니스 로직(행동) : [2]
        // [1] 은 [2] 를 수행하기 위한 부가적인 기능
    }

    // 메소드_2
    public  void enter2(){
        System.out.println("[코로나] 온도 체크 => 보안");  // [1]
        System.out.println("학원 입장");          // [2]
        // 비즈니스 로직(행동) : [2]
        // [1] 은 [2] 를 수행하기 위한 부가적인 기능
    }
}
public class Example1 {
    public static void main(String[] args) {
        TestService testService = new TestService();
        testService.enter1();
        testService.enter2();

        // 단점 : 유지보수 복잡 => 하나의 메소드에서 부가기능 수정 시 다른 메소드에서도 수정해야함
    }
}
