package example.day03.mvc2_mybatis.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MyDto {

    private int id;
    private String name;
    private int age;

}
