package example.day06._day06과제.controller;

import example.day06._day06과제.service.AopClass;
import example.day06._day06과제.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day06")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AopClass aopClass;

    // [1] 학생점수등록
    @PostMapping
    public int save(@RequestBody HashMap<String, Object> map){ // DTO 대신 HashMap 사용
        //aopClass.beforeCheck("save", map);


        int result =  studentService.save(map);
        //aopClass.afterCheck(result);

        return  result;
    }
    // [2] 학생 점수
    @GetMapping
    public List<Map<String, Object>> findAll(){
        //aopClass.beforeCheck("findAll", null);


        List<Map<String,Object>> result = studentService.findAll();

        //aopClass.afterCheck(result.toString());

        return result;
    }

}
