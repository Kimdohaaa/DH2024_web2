package example.day13._람다식;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// [2] 인터페이스의 추상메소드
interface Calculator{
    // [2] 더하기 추상 메소드 (구현부 X)
    int plus(int x, int y);
}
public class Example1 {
    // [1] 일반 더하기 메소드
    public static int plus(int x, int y){
        return x + y;
    }

    public static void main(String[] args) {
        // [1] 일반 메소드 호출
        int result1 = plus(3 , 5);

        // [2] 추상메소드 익명 객체로 호출 (구현 필요 (1) implement (2) 익명객체 사용)
        // 추상메소드가 객체를 생성할 수 없는 이유 (1) 구현부가 없기 때문 (2) 생성자가 없기 때문
        // => 익명객체 사용만 가능(이름없는 객체로 추상화를 구현) : 인터페이스명 변수명 = new 인터페이스명 () { @Override 구현 (중괄호 안이 객체를 의미) };
        Calculator cal = new Calculator() { // 익명 객체로 구현
            @Override
            public int plus(int x, int y) {
                return x + y; // 구현
            }
        };
        int result2 = cal.plus(3, 5);

        // [3] 추상메소드 람다표현식으로 호출 : 인터페이스명 변수명 = ((매개변수) -> 구현코드);
        Calculator cal3 = ((x, y) -> x + y);
        int result3 = cal3.plus(3, 5);

        /// ************************************************************************* //

        // [1] 람다표현식을 제공하는 타입
        // 1) Function<매개변수타입, 리턴타입> 변수명 = 매개변수 -> 구현코드 ;
        //    ===> .apply(인자값) 메소드를 통해 매개변수를 받고 메소드 실행 후 결과 반환
        Function<Integer, Integer> function = x -> x * 2;
        System.out.println(function.apply(3)); // .apply(인자값) : 매개변수를 전달하여 메소드 실행 ---> 3 * 2
        System.out.println(function.apply(7)); // .apply(인자값) : 매개변수를 전달하여 메소드 실행 ---> 7 * 2
        System.out.println(function.apply(5)); // .apply(인자값) : 매개변수를 전달하여 메소드 실행 ---> 5 * 2

        // 2) Predicate<매개변수타입>  변수명 = 매개변수 -> 구현코드 : 구현코드의 실행결과를 boolean 타입으로 반환
        //    ===> .test(인자값) 메소드를 통해 매개변수를 받고 메소드 실행 후 결과를 boolean 타입로 반환
        Predicate<Integer> predicate = x -> x % 2 == 0;
        System.out.println(predicate.test(3)); // .test(인자값) : 매개변수를 전달하여 메소드 실행 ---> false
        System.out.println(predicate.test(4)); // .test(인자값) : 매개변수를 전달하여 메소드 실행 ---> true

        // 3) Supplier<리턴타입>  변수명 = () -> 구현코드 ;
        //   ===> 제네릭타입에 리턴타입만 입력하고 매개변수가 없기 때문에 .get() 메소드를 통해 반환만 가능
        Supplier<Double>  supplier = () -> Math.random();
        System.out.println(supplier.get()); // 인자값이 없으므로 .get() 메소드를 통해 반환만 가능

        // 4) Consumer<매개변수타입> 변수명 = 매개변수 -> 구현코드 ;
        //   ===> .accept(인자값) : 매개변수를 전달하여 메소드 실행
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("안녕"); // .accept(인자값) : 매개변수를 전달하여 메소드 실행 ---> "안녕" 출력


        // [2] 람다식을 이용한 컬렉션 프레임워크 사용
        // 1) List 인스턴스 생성
        List<String> 과일목록 = new ArrayList<>();

        // 2) 리스트에 값 추가
        과일목록.add("사과");
        과일목록.add("딸기");
        과일목록.add("복숭아");

        // 3) 리스트명.forEach(Consumer); => .forEach() 메소드가 리턴값이 없는 이유 (Consumer 타입을 사용하기 때문)
        과일목록.forEach((과일) -> {
            System.out.println("과일명 : " + 과일);
        });
    }
}
