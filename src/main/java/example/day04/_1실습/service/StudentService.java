package example.day04._1실습.service;

import example.day04._1실습.model.dto.StudentDto;
import example.day04._1실습.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;

    // [1] 학생 등록
    public int add(StudentDto studentDto){
        System.out.println("StudentService.add");
        System.out.println("studentDto = " + studentDto);

        int result = studentMapper.add(studentDto);
        return  result;
    }

    // [2] 학생 전체 조회
    public List<StudentDto> findAll(){
        System.out.println("StudentService.findAll");

        List<StudentDto> result = studentMapper.findAll();
        return  result;
    }

    // [3] 학생 개별 수정
    public  int update(StudentDto studentDto){
        System.out.println("StudentService.update");
        System.out.println("studentDto = " + studentDto);

        int result = studentMapper.update(studentDto);
        return  result;
    }

    // [4] 학생 개별 삭제
    public  int delete(int sno){
        System.out.println("StudentService.delete");
        System.out.println("sno = " + sno);

        int result = studentMapper.delete(sno);
        return  result;
    }
}
