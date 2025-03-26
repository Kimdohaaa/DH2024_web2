package example.day13._메소드래퍼런스;

import java.util.List;
import java.util.function.Supplier;

class Person{
    String name; // 멤버변수
    public Person(){}; // 디폴트 생성자
    public Person(String name){ //풀 생성자
        this.name = name;
    }

    public void onMessage1(String message){ // 일반 메소드
        System.out.println(message);
    }

    public static void onMessage2 (String message){ // static 메소드
        System.out.println(message);
    }
}

public class Example3 {
    public static void main(String[] args) {
        // [1] 리스트 생성 후 초기값 선언
        List<String> names = List.of("유재석", "강호동", "신동엽");

        // [2] static 메소드 참조
        // 1) 일반적인 방법
        names.forEach( (name) -> Person.onMessage2(name));
        // 2) 메소드 참조 레퍼런스 방법 : 클래스명::메소드명
            // forEach 의 매개변수와 static 메소드의 매개변수가 일치할 때만 사용 가능(매개변수를 자동으로 전달하기 때문)
        names.forEach(Person::onMessage2);

        // [3] 생성자 참조
        // 1) 일반적인 방법
        names.forEach((name) -> { new Person(name); });
        // 2) 생성자 참조 레퍼런스 방법 : 클래스명::new
            // forEach 의 매개변수와 생성자 매개변수가 일치할 때만 사용 가능
        names.forEach(Person::new);


        // [3] 일반 메소드 레퍼런스 참조
        // 1) 인스턴스 생성
        Person person1 = new Person();
        // 2) 일반 메소드 참조 레퍼런스 방법 : 인스턴스명::일반메소드명
        names.forEach(person1::onMessage1);

        // [4] 레퍼런스 사용 시 주의점
        // 람다표현식을 간결하게 작성하는 것이 목적이기 때문에 레퍼런스를 바로 사용하는 것은 불가
        // Person person2 = Person::new; // 오류발생
        Supplier<Person> ref1 = Person::new;
        Person person2 = ref1.get();
    }

}
