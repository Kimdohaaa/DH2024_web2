package example.day07.task.model.mapper;

import example.day07.task.model.dto.TaskDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Insert("insert into task (tname, tphone) values (#{tname}, #{tphone})")
    boolean onPost(TaskDto taskDto);

    @Select("select * from task")
    List<TaskDto> findAll();
}
