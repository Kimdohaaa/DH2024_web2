package example.day03.mvc2_3tire.controller;

import example.day03.mvc2_3tire.service.MvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
// MVC 패턴의 Controller 임을 알리는 어노테이션
// 사용목적 : Spring 컨테이너(메모리) 에 등록함으로써 Spring 이 자동으로 컨트롤러 제어 => IOC(제어의 역전)
public class MvcController {
    // @Autowired : 필드에게 Spring 컨테이너(메모리) 에 등록된 빈(객체)을 주입하는 어노테이션

    // [1] 어노테이션을 통해 Controller 에서 Service 호출
    // 필드를 이용하는 bean 을 주입하는 방법
    @Autowired
    MvcService mvcService;

}
