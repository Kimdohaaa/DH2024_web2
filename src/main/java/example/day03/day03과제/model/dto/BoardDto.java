package example.day03.day03과제.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BoardDto {
    private int bno;
    private  String title;
    private  String content;
}
