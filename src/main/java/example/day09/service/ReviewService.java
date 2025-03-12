package example.day09.service;

import example.day09.model.dto.ReviewDto;
import example.day09.model.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    // [1] 리뷰 등록
    public boolean write(ReviewDto reviewDto){
        System.out.println("ReviewService.write");
        System.out.println("reviewDto = " + reviewDto);

        return reviewMapper.write(reviewDto);
    }

    // [2] 리뷰 조회
    public List<ReviewDto> findAll(){
        System.out.println("ReviewService.findAll");
        System.out.println();

        return reviewMapper.findAll();
    }

    // [3] 리뷰 삭제
    public boolean delete(ReviewDto reviewDto){
        System.out.println("ReviewService.delete");
        System.out.println("reviewDto = " + reviewDto);

        return reviewMapper.delete(reviewDto);
    }
}
