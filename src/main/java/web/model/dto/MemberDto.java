package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // @Data : Getter , Setter , ToString 이 포함된 어노테이션
@AllArgsConstructor
@NoArgsConstructor
@Builder // @Builder : 빌더 패턴 지원 어노테이션
public class MemberDto { // 회원 DTO
    // DB 테이블에 필요한 멤버 변수
    private int mno;
    private  String mid;
    private  String mpwd;
    private  String mname;
    private  String mimg;

    // 그 외
}
