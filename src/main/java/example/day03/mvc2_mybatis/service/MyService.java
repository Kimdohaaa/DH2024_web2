package example.day03.mvc2_mybatis.service;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import example.day03.mvc2_mybatis.model.mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    @Autowired
    private MyMapper myMapper;

    // Controller 의 Post 매핑
    public int save(MyDto myDto){
        System.out.println("MyService.save");
        System.out.println("myDto = " + myDto);

        // Controller 에게 Request 값 Mapper 로 전달
        int result = myMapper.save(myDto);

        return 1;
    }

    // Controller 의 Get 매핑
    public List<MyDto> findAll(){
        System.out.println("MyService.findAll");

        // Controller 에게 Request 값 Mapper 로 전달
        List<MyDto> result = myMapper.findAll();
        return  result;
    }

    public MyDto find(int id){
        System.out.println("MyService.find");
        System.out.println("id = " + id);

        // Controller 에게 Request 값 Mapper 로 전달
        MyDto result = myMapper.find(id);
        return result;
    }
    // Controller 의 Put 매핑
    public int update(MyDto myDto){
        System.out.println("MyService.updatte");
        System.out.println("myDto = " + myDto);

        // Controller 에게 Request 값 Mapper 로 전달
        int result = myMapper.update(myDto);
        return result;
    }
    // Controller 의 Delete 매핑
    public int delete(int id){
        System.out.println("MyService.delete");
        System.out.println("id = " + id);

        // Controller 에게 Request 값 Mapper 로 전달
        int result = myMapper.delete(id);
        return  result;
    }
}
