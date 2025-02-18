package example.day02._2의존성;
// [3] Spring 방법을 이용한 메소드 호출 (IOC 와 DI)
// -> 멤버변수 필드에 bean 등록

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// [3-1] 서비스 클래스
@Component
// @Component : Spring 컨테이너(메모리) 에 bean(인스턴스) 를 등록하는 어노테이션
// bean : Spring 컨테이너(메모리) 에서 관리하는 인스턴스 / 객체 => IOC(제어의 역전)
// IOC : 개발자가 인스턴스를 생성하지 않고 Spring 이 대신 인스턴스를 생성함
class SampleService3{
   void method(){
       System.out.println("SampleService3.method");
   }
}

// [3-3] 컨트롤러 클래스
class SampleController3{
    @Autowired
    // @Autowired : Spring 컨테이너(메모리) 에 등록된 bean(인스턴스) 을 주입 => DI
    private SampleService3 sampleService3;
    public void method(){
        sampleService3.method();
    }
}

public class Example3 {
}
