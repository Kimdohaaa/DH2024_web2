package example.day05.controller;

import example.day05.service.StudentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/day05/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // [1] 학생 등록
    @PostMapping
    public int save(@RequestBody HashMap<String, Object> map){ // DTO 대신 HashMap 사용
        System.out.println("StudentController.save");
        System.out.println("map = " + map);

        return studentService.save(map);
    }

    // [2] 전체 조회
    @GetMapping
    public List<Map<String, Object>> findAll(){
        System.out.println("StudentController.findAll");
        System.out.println();

        return studentService.findAll();

    }

    // [3] 특정 점수 이상 학생 조회 (동적 쿼리 사용)
    @GetMapping("/find/scores")
    public List<Map<String, Object>> findStudentScore(@RequestParam int minKor
                                            , @RequestParam int minMath){
        return studentService.findStudentScore(minKor, minMath);
    }
    // [4] 개별조회
    @GetMapping("/view")
    public Map<String, Object> view(@RequestParam("sno") int sno){
        System.out.println("StudentController.view");
        System.out.println("sno = " + sno);

        return studentService.view(sno);
    }

    // [5] 학생 수정
    @PutMapping
    public  int update(@RequestBody HashMap<String, Object> map){
        System.out.println("StudentController.update");
        System.out.println("map = " + map);

        return studentService.update(map);
    }

    // [6] 학생 삭제
    @DeleteMapping
    public boolean delete(@RequestParam("sno") int sno){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);

        return studentService.delete(sno);
    }

    // [7] 한번에 여러명의 학생 등록
    @PostMapping("/save/all")
    public boolean saveAll(@RequestBody List<Map<String, Object>> list){ // 여러 학생정보를 한번에 받기 위해 List 타입 사용
        System.out.println("StudentController.saveAll");
        System.out.println("list = " + list);

        return studentService.saveAll(list);

    }
}
