package example.day02._2의존성;

// 컨트롤러에서 서비스 클래스의 메소드 호출
// 다른 클래스의 메소드를 호출하는 방법

// [1] 인스턴스 생성을 통해 메소드 호출
// -> 스프링없이 객체를 직접 생성하여 메소드 사용
// -> 단점 : 강한 결합 으로 유지보수가 어려워진다.

// [1-1] 서비스 클래스
class SampleService1{
    void method(){
        System.out.println("SampleService1.method");
    }
}

// [1-2] 컨트롤러 클래스
class SampleController1{

    SampleService1 sampleService1 = new SampleService1();
    public void method(){
        sampleService1.method();
    }
}


public class Example1 {

}
