package example.day09.controller;

import example.day09.model.dto.ReviewDto;
import example.day09.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin("http://localhost:5181")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    // [1] 리뷰 등록
    @PostMapping
    public boolean write(@RequestBody ReviewDto reviewDto){
        System.out.println("ReviewController.write");
        System.out.println("reviewDto = " + reviewDto);

        return  reviewService.write(reviewDto);
    }

    // [2] 리뷰 조회
    @GetMapping
    public List<ReviewDto> findAll(){
        System.out.println("ReviewController.findAll");
        System.out.println();

        return reviewService.findAll();
    }

    // [3] 리뷰 삭제
    @PostMapping("/delete")
    public boolean delete(@RequestBody ReviewDto reviewDto){
        System.out.println("ReviewController.delete");
        System.out.println("reviewDto = " + reviewDto);

        return reviewService.delete(reviewDto);
    }
}
