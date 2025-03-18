package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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
    private  String mimg; // 업로드된 파일의 파일명 (DB)

    // 그 외
    private MultipartFile uploadfile; // 업로드된 파일의 바이트 인터페이스 (Form 전송 시)
    // 만약 여러개의 첨부파일을 한번에 조작할 시 List<MultipartFile> 타입 사용
}
