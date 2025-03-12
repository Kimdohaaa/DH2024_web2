package example.day09.model.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookDto {
    private int bno;
    private  String bname;
    private  String  bcontent;
    private  String bpwd;
}
