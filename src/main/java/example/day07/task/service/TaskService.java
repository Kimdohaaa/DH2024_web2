package example.day07.task.service;

import example.day07.task.model.dto.TaskDto;
import example.day07.task.model.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskMapper taskMapper;

    public boolean onPost(TaskDto taskDto){
        System.out.println("TaskService.onPost");
        System.out.println("taskDto = " + taskDto);

        return taskMapper.onPost(taskDto);
    }

    public List<TaskDto> findAll(){
        System.out.println("TaskService.findAll");
        System.out.println();

        return  taskMapper.findAll();
    }
}
