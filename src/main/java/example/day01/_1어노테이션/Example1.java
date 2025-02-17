package example.day01._1어노테이션;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// 상위 클래스
class SuperClass {
    public void method1(){}
}
// 하위 클래스 (SuperClass 를 상속받음)
class SubClass extends SuperClass{

    // [1] @Override : 부모클래스로부터 상속받은 메소드 오버라이드
    @Override
    public void method1() {
        super.method1();
    }

    // [2] @Deprecated : 더이상 사용하지 않는 코드임의 알림
    @Deprecated
    public void method2() {

    }
}

// 사용자 지정 어노테이션 //
// [1] 어노테이션 생성
    // 형식 : @interface 인터페이스명 { }
@Retention(RetentionPolicy.RUNTIME) // 런타임까지 유지
@Target(ElementType.METHOD) // 해당 어노테이션은 메소드에만 적용
@interface Annotation1{

    // [2] 추상메소드 생성
    String value1();

}
// [3] 사용자 지정 어노테이션 사용
class TestClass {

    @Annotation1(value1 = "value1 값 지정")
    public void method(){
        // value1 이라는 값을 내부적으로 사용 가능
        // 런타임(실행 시) 컴파일되기 때문에 코드적으로는 사용불가
    }
}

public class Example1 {
    public static void main(String[] args) throws Exception{

        // 기본 어노테이션 사용 //
        SubClass subClass = new SubClass();
        subClass.method1();
        subClass.method2(); // [3] @Deprecated 어노테이션을 사용했기때문에 비권장 메소드(더이상 사용하지 않는 메소드

        // [4] 리플렉션된 클래스 정보 확인
        try{
            Method method = TestClass.class.getMethod("method3");
            Annotation1 annotation1 = method.getAnnotation(Annotation1.class);
            System.out.println(annotation1.value1());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
