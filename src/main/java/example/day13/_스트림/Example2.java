package example.day13._스트림;

import java.util.List;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {

        // [1] 리스트 선언
        // List.of(값1, 값2 , 값3) : 리스트의 초기값을 지정하는 메소드
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 제네릭타입은 기본타입 못 씀!
        // int(기본타입) vs Integer(래퍼클래스 : 자바의 기본타입을 객체로 다루기 위해 사용하는 클래스)

        // [2] 컬렉션 프레임워크를 통해 스트림 생성
        // 리스트명.stream().forEach()
        numbers.stream() // 스트림 생성
                .forEach(x -> System.out.println(x));

        // [3] 컬렉션 프레임 워크에 스트림을 통해 .map(Function) 사용하기 => .map() 메소드에는 Function 타입을 사용함
        // 리스트명.stream().map().collect(Collectors.to컬렉션명())
        // .map() : 중간 연산
        // .collect() : 최종 연산
        List<Integer> result2 = numbers.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList()); // .collect(Collectors.toList()) : map 리턴값을 List 타입으로 반환

        System.out.println(result2);

        // [3] 리스트명.stream().map().forEach()
        // .map() : 중간연산
        // .forEach() : 최종 연산
        numbers.stream() // 1) numbers 의 데이터를 하나씩 이동시키는 스트림 통로 생성
                .map(x -> x * 2) // 2) 데이터 통로를 이동하면서 데이터를 중간 연산 처리
                .forEach(x -> System.out.println(x)); // 3) 데이터 통로의 끝에서 데이터 결과 출력

        // [4] 리스트명.stream().filter().forEach() 를 통해 중간연산으로 짝수만 필터처리
        // .filter() : 중간연산
        // .forEach() : 최종연산
        numbers.stream() // 1) 스트림 통로 생성
                .filter(x -> x % 2 == 0) // 2) 중간연산 : 짝수만 필터
                .forEach(x -> System.out.println(x)); // 3) 최종 연산 : 필터된 짝수만 출력

        // [5] 리스트명.stream().sorted().forEach() 를 통해 중간연산으로 오름차순정렬 처리
        numbers.stream()
                .sorted() // sorted(Comparator.reverseOrder()) : 내림차순 정렬
                .forEach(x -> System.out.println(x));
    }
}
