package example.day06._day06과제.service;

import example.day06._day06과제.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AopClass aopClass;

    // [1] 학생등록
    public  int save(HashMap<String, Object> map){
        //aopClass.beforeCheckService("save", map);

        int result = studentMapper.save(map);

        //aopClass.afterCheckService(result);
        return result;
    }


    // [2] 전체 조회
    // 전체조회
    public List<Map<String, Object>> findAll(){

        //aopClass.beforeCheckService("findAll", null);
        List<Map<String, Object>> result = studentMapper.findAll();
        //AopClass.afterCheckService(result);
        return result;
    }

}
