package example.day09.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReviewDto {

    private int rno;
    private  String rcontent;
    private  String rpwd;
    private  int bno;
    private  String  bname;
}
