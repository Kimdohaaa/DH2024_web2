package example.day10;

import lombok.Builder;

@Builder // lombok 에서 지원하는 빌더 패턴
class MemberDto{
    private  String name;
    private  int age;

    // 생성자
    public MemberDto(String name , int age){
        this.name = name;
        this.age = age;
    }

}

public class Example1 {
    public static void main(String[] args) {

        // [1] MemberDto 객체 생성 시 초기값을 대입하는 방법(생성장)
        MemberDto memberDto = new MemberDto("유재석", 40);
        /*
        생성자 규칙
        1. 정의된 생성자만 사용가능
        2. 생성자의 매개변수 순서, 타입, 개수가 일치해야 함
        */

        // 생성자의 불편함을 해결하기 위해 Builder pattern 사용
        // Builder pattern : 복잡한 객체 생성 과정을 단순화 해주는 디자인 패턴
        // lombok 에서 지원하는 @Builder 어노테이션을 통해 주입하여 사용

        // [2] lombok 에서 지원하는 @Builder 어노테이션 객체 생성
        // => 클래스명 변수명 = 클래스명.builder().필드명(초기값).필드명(초기값).build();
        MemberDto memberDto1 = MemberDto.builder().name("유재석").age(40).build();
        MemberDto memberDto2 = MemberDto.builder().build();
        MemberDto memberDto3 = MemberDto.builder().name("강호동").build();
        MemberDto memberDto4 = MemberDto.builder().age(30).name("서장훈").build();

    }
}
