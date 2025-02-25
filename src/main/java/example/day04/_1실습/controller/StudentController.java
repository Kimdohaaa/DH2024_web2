package example.day04._1실습.controller;

import example.day04._1실습.model.dto.StudentDto;
import example.day04._1실습.service.StudentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    // [1] 학생점수 등록
    @PostMapping
    public  int add (@RequestBody StudentDto studentDto){
        System.out.println("StudentController.add");
        System.out.println("studentDto = " + studentDto);

        int result = studentService.add(studentDto);
        return  result ;
    }

    // [2] 학생 전체 조회
    @GetMapping
    public List<StudentDto> findAll(){
        System.out.println("StudentController.findAll");

        List<StudentDto> result = studentService.findAll();
        return  result;
    }

    // [3] 학생 개별 수정
    @PutMapping
    public int update(@RequestBody StudentDto studentDto){
        System.out.println("StudentController.update");
        System.out.println("studentDto = " + studentDto);

        int result = studentService.update(studentDto);
        return  result;
    }

    // [4] 학생 개별 삭제
    @DeleteMapping
    public int delete(@RequestParam("sno") int sno){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);

        int result = studentService.delete(sno);
        return  result;
    }

}
