package example.day02._2의존성;
// [2] 싱글톤을 사용하여 메소드 호출
// -> 프로그램 내 하나의 인스턴스가 하나만 필요로 할 때 사용


// [2-1] 서비스 클래스
class SampleService2{
    // 싱글톤 s
    private static SampleService2 instance = new SampleService2();
    private SampleService2(){}
    public static SampleService2 getInstance(){ return  instance; }
    // 싱글톤 e

    void method(){
        System.out.println("SampleService2.method");
    }
}

// [2-2] 컨트롤러 클래스
class  SampleController2{

    SampleService2 sampleService2 = SampleService2.getInstance();
    public  void  method(){
        sampleService2.method();
    }
}



public class Example2 {
}
