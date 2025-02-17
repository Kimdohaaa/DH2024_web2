package example.day01._1어노테이션;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// [1] 어노테이션 만들기
// 1) @interface 어노테이션명 {}
@Retention(RetentionPolicy.RUNTIME) // 2) @Retention 어노테이션으로 리플렉션 지정
@Target(ElementType.METHOD)          // 2) @Target 어노테이션으로 적용할 대상 지정
@interface  Annotation2{

    // 2) 추상메소드 생성
    String value1();
    int value2() default 100;   // default 를 통해 기본값 지정

}

// [3] 어노테이션 사용
class TestClass2{

    // [4]지정한 코드에 @어노테이션명 을 통해 어노테이션 주입
    @Annotation2(value1 = "유재석", value2 = 40)
    public void method1(){} // 해당 함수 안에서 value1, value2 내부적으로 사용가능

    @Annotation2(value1 = "강호동")
    public void method2(){} // 지정하지않은 value2 는 default 값이 대입됨
}


// // //
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)   // 적용대상을 클래스,인터페이스,열거형 타입으로 지정
@interface Annotation3{
    String value1();
    int value2() default 100;
}

@Annotation3(value1 = "유재석" , value2 = 40) // 클래스에 어노테이션 주입
class Member{

}



public class Example2 {
    public static void main(String[] args) throws Exception{

        // 멤버 클래스의 어노테이션의 클래스 정보 확인
        Annotation3 annotation3 = Member.class.getAnnotation(Annotation3.class);
        System.out.println(annotation3.value1());
        System.out.println(annotation3.value2());

    }
}
