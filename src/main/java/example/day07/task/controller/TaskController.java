package example.day07.task.controller;

import example.day07.task.model.dto.TaskDto;
import example.day07.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin("http://192.168.40.24:5181")
public class TaskController {

    @Autowired
    TaskService taskService;

    // 전화번호부 등록
    @PostMapping("")
    public boolean onPost (@RequestBody TaskDto taskDto){
        System.out.println("TaskController.onPost");
        System.out.println("taskDto = " + taskDto);

        return taskService.onPost(taskDto);

    }

    // 전화번호부 출력
    @GetMapping("")
    public List<TaskDto> findAll(){
        System.out.println("TaskController.findAll");

        System.out.println(taskService.findAll());
        return taskService.findAll();

    }

}
