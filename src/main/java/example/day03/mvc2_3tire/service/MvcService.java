package example.day03.mvc2_3tire.service;

import example.day03.mvc2_3tire.model.repository.MvcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// MVC 패턴의 Service 임을 알리는 어노테이션
// 사용목적 : Spring 컨테이너(메모리) 에 등록함으로써 자동으로 Service 제어 => IOC(제어의 역전)
public class MvcService {

    // @Autowired : 필드에게 Spring 컨테이너(메모리) 에 등록된 빈(객체)을 주입하는 어노테이션
    // final 키워드를 통해 상수로 지정하기 위해서는 초기값 지정이 필요한데 @Autowired 어노테이션은 new 로 인스턴스를 생성하는
    // 과정을 간소화 하기 위함으로 @Autowired 어노테이션과 final XXX = new XXX 시 @Autowired 쓰는 의미가 없어짐!


    // [1] 어노테이션을 통해 Service 에서 Repository 호출
    // (디폴트)생성자를 이용하는 bean 주입 방법 -> 필드에 final 을 사용할 때 주로 사용하는 방법
    final  MvcRepository mvcRepository;
    @Autowired
    MvcService(MvcRepository mvcRepository){
        this.mvcRepository = mvcRepository;
    }

}
