package example.day02._2의존성;
// [4] Spring 방법을 이용한 메소드 호출 (IOC 와 DI)
// -> 생성자에 bean 등록

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// [4-1] 서비스 클래스
@Service // @Component 가 포함된 어노테이션
class SampleService4{
    void method(){
        System.out.println("SampleService4.instance initializer");
    }
}

// [4-2] 컨트롤러 클래스
class SampleController4{
    private final SampleService4 sampleService4;
    @Autowired
    // 생성자를 이용하여 bean 을 등록하는 방법
    public SampleController4 (SampleService4 sampleService4){
        this.sampleService4 = sampleService4;
    }

    public void  method(){
        sampleService4.method();
    }
}

public class Example4 {
}
