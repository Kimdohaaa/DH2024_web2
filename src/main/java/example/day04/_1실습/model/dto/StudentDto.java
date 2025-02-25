package example.day04._1실습.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor  @AllArgsConstructor
public class StudentDto {
    private  int sno;
    private  String name;
    private  int kor;
    private  int math;
}
