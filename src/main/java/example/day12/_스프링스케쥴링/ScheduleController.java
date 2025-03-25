package example.day12._스프링스케쥴링;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day11/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    // 스프링의 스케쥴링을 REST API 에서 강제로 실행
    @GetMapping("/task3")
    public void task(){
        scheduleService.task3();
    }

}
