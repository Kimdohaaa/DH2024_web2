package example.day12.day12_task.service;

import example.day12.day12_task.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    // [1] 매 30 초마다 제품의 재고는 3개씩 감소
    @Scheduled(cron = "*/30 * * * * *")
    public void task1(){
        System.out.println("매 30 초마다 제품의 재고는 3개씩 감소");

        taskMapper.task1();
    }

    // [2] 매 1분마다 모든 제품정보를 조회하여 console에 출력
    @Scheduled(cron = "0 */1 * * * * ")
    public void task2(){
        System.out.println("매 1분마다 모든 제품정보를 조회하여 console에 출력");

        List<HashMap<String, String>> result = taskMapper.task2();


        for (HashMap<String, String> product : result) {
            System.out.println(product);
        }

    }

    // [3] 매 5분마다 재고가 10이하인 상품의 재고를 20개 추가
    @Scheduled(cron = "0 */5 * * * *")
    public void task3(){
        System.out.println("매 5분마다 재고가 10이하인 상품의 재고를 20개 추가");

        taskMapper.task3();
    }
}
