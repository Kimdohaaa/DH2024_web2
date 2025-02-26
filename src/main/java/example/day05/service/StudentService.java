package example.day05.service;

import example.day05.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public  int save(HashMap<String, Object> map){
        System.out.println("StudentService.save");
        System.out.println("map = " + map);
        // map = {name=유재석,math=90,kor=30} => SQL 처리 전 sno 존재 x

        int result = studentMapper.save(map);
        System.out.println("result = " + result);
        // result = 1 => SQL 실행 결과 처리된 레코드 수

        System.out.println("map = " + map);
        // map = {sno=4,name=유재석,math=90,kor=30} => SQL 처리 후 sno 존재 O
        // DB 에서 auto_increment 를 통해 생성된 PK 키 sno 가 Mapper 인터페이스에서 @Options 를 통해 매개변수에 저장되었기 때문

        return result;
    }

    // 전체조회
    public List<Map<String, Object>> findAll(){
        System.out.println("StudentService.findAll");

        return studentMapper.findAll();
    }

    // 특정 점수 이상 학생 조회 (동적 쿼리 사용)
    public List<Map<String,Object>> findStudentScore(int minKor, int minMath){
        return studentMapper.findStudentScore(minKor, minMath);
    }

    // 개별조회
    public Map<String, Object> view(int sno){
        System.out.println("StudentService.view");
        System.out.println("sno = " + sno);
        return studentMapper.view(sno);
    }

    // 수정
    public int update(HashMap<String, Object> map){
        System.out.println("StudentService.update");
        System.out.println("map = " + map);

        return studentMapper.update(map);
    }

    // 삭제
    public boolean delete(int sno){
        System.out.println("StudentService.delete");
        System.out.println("sno = " + sno);

        return studentMapper.delete(sno);
    }

    // 한번의 여러 명의 학생 등록
    public boolean saveAll(List<Map<String, Object>> list){
        System.out.println("StudentService.saveAll");
        System.out.println("list = " + list);

        return studentMapper.saveAll(list);
    }
}
