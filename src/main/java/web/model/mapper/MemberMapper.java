package web.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import web.model.dto.MemberDto;

@Mapper
public interface MemberMapper {

    // [1] 회원가입 (첨부파일X)
    @Insert("INSERT INTO member (mid, mpwd, mname, mimg) VALUES (#{mid}, #{mpwd}, #{mname}, #{mimg})")
    boolean signup(MemberDto memberDto);

    // [2] 로그인
    // boolean  타입으로 return 시 존재하지 않는 정보면 예외 발생
    // DTO 타입으로 리턴 시 존재하는 정보면 DTO 에 저장 , 존재하지 않는 정보면 null 저장
    // mpwd 는 비밀번호로 보안이 중요하기 때문에 가져오지 않기 
    // 2-1) 암호화 전 코드
    // @Select("select mno, mid, mname from member where mid = #{mid} and mpwd = #{mpwd}")
    // MemberDto login(MemberDto memberDto);

    // 2-2) 암호화 후 코드 => DB 에서 비밀번호 검증 불가
    // *)로그인 시 입력받은 아이디로 해당 아이디에 해당되는 암호화된 패스워드 조회
    @Select("select mpwd from member where mid = #{mid}")
    String findPassword(String mid);

    // *) 로그인 비밀번호 검정 성공 시 반환할 회원정보 조회
    @Select("select mno, mid, mname , mimg from member where mid= #{mid}")
    MemberDto login(MemberDto memberDto);


}
