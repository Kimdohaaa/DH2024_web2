package example.day13.day13_task;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
class fruites{
    public static void method(String f){
        System.out.println(f);
    }
}
public class task {
    public static void main(String[] args) {
        List<String> 과일들 = List.of("사과", "바나나", "체리", "대추", "포도");

    // 1.[메소드 레퍼런스 사용안함]  forEach함수를 활용하여 과일들을 하나씩 console에 출력하시오.
    과일들.forEach((i) -> System.out.println("1번 : "  + i));
    // 2.[메소드 레퍼런스 사용안함]  map함수를 활용하여 과일들을 하나씩 console에 출력하시오.
    과일들.stream().map((i) ->i).forEach((i) -> System.out.println("2번 : "  +i));
    // 3.[메소드 레퍼런스 사용안함]  filter함수를 활용하여 과일들 중에 '바나나' 또는 '대추'만 console에 출력하시오.
    과일들.stream().filter((i) ->  i == "바나나" || i == "대추").forEach((i) -> System.out.println("3번 : "  +i));
    // 4.[메소드 레퍼런스 사용안함]  sorted함수를 활용하여 과일들을 내림차순으로 정렬하여 하나씩 console에 출력하시오.
    과일들.stream().sorted(Comparator.reverseOrder()).forEach(i -> System.out.println("4번 : "  +i));
    // 5.[메소드 레퍼런스 사용함]  forEach함수를 활용하여 과일들을 하나씩 console에 출력하시오.
    과일들.forEach(System.out::println);
    // 6.[메소드 레퍼런스 사용함]  map함수를 활용하여 과일들을 하나씩 console에 출력하시오.
    과일들.stream().map((i) -> i).forEach(System.out::println);
    // 7.[메소드 레퍼런스 사용함]  filter함수를 활용하여 과일들 중에 '바나나' 또는 '대추'만 console에 출력하시오.
    과일들.stream().filter((i) ->  i == "바나나" || i == "대추").forEach(System.out::println);
    // 8.[메소드 레퍼런스 사용함]  sorted함수를 활용하여 과일들을 내림차순으로 정렬하여 하나씩 console에 출력하시오.
    과일들.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
